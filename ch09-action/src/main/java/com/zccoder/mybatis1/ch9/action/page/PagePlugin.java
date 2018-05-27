package com.zccoder.mybatis1.ch9.action.page;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 标题：分页插件<br>
 * 描述：分页插件<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})
})
public class PagePlugin implements Interceptor {

    public static final String NAME_H = "h";
    /**
     * 默认页码
     */
    private Integer defaultPage;
    /**
     * 默认分页条数
     */
    private Integer defaultPageSize;
    /**
     * 默认是否启动插件
     */
    private Boolean defaultUseFlag;
    /**
     * 默认是否检测当前页码的有效性
     */
    private Boolean defaultCheckFlag;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = getUnProxyObject(invocation);
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        // 不是 select 语句
        if (!checkSelect(sql)) {
            return invocation.proceed();
        }
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object parameterObject = boundSql.getParameterObject();
        PageParams pageParams = getPageParams(parameterObject);
        // 没有分页参数，不启用插件
        if (pageParams == null) {
            return invocation.proceed();
        }
        // 获取分页参数，获取不到时使用默认值
        Integer pageNum = pageParams.getPage() == null ? this.defaultPage : pageParams.getPage();
        Integer pageSize = pageParams.getPageSize() == null ? this.defaultPageSize : pageParams.getPageSize();
        Boolean useFlag = pageParams.getUseFlag() == null ? this.defaultUseFlag : pageParams.getUseFlag();
        Boolean checkFlag = pageParams.getCheckFlag() == null ? this.defaultCheckFlag : pageParams.getCheckFlag();
        // 不使用插件
        if (!useFlag) {
            return invocation.proceed();
        }
        int total = getTotal(invocation, metaStatementHandler, boundSql);
        // 回填总数到分页参数里
        setTotalToPageParams(pageParams, total, pageSize);
        // 检查当前页码的有效性
        checkPage(checkFlag, pageNum, pageParams.getTotalPage());
        // 修改SQL
        return changeSQL(invocation, metaStatementHandler, boundSql, pageNum, pageSize);
    }

    /**
     * 修改当前查询的SQL
     */
    private Object changeSQL(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql, Integer pageNum, Integer pageSize)throws Throwable {
        // 当前需要执行的SQL
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        // 修改SQL：这里需要区分数据库系统（如：MySQL、Oracle等）
        String newSql = "select * from (" + sql + ")$_paging_table limit ?,?";
        // 修改当前需要执行的SQL
        metaStatementHandler.setValue("delegate.boundSql.sql",newSql);
        // 编译SQL
        PreparedStatement ps = (PreparedStatement) invocation.proceed();
        // 计算SQL总参数个数
        int count = ps.getParameterMetaData().getParameterCount();
        // 设置两个分页参数
        ps.setInt(count -1,(pageNum -1 ) * pageSize);
        ps.setInt(count,pageSize);
        return ps;
    }

    /**
     * 检查当前页码的有效性
     */
    private void checkPage(Boolean checkFlag, Integer pageNum, Integer totalPage)throws Throwable {
        if (checkFlag){
            // 检查页码page是否合法
            if (pageNum > totalPage){
                throw new Exception("查询失败，查询页码【"+pageNum+"】大于总页数【"+totalPage+"】");
            }
        }
    }

    /**
     * 回填总条数和总页数到分页参数
     */
    private void setTotalToPageParams(PageParams pageParams, int total, Integer pageSize) {
        pageParams.setTotal(total);
        // 计算总页数
        int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        pageParams.setTotalPage(totalPage);
    }

    /**
     * 获得分页总数
     */
    private int getTotal(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql)throws Throwable {
        // 获取当前的mappedStatement
        MappedStatement mappedStatement = (MappedStatement)metaStatementHandler.getValue("delegate.mappedStatement");
        // 配置对象
        Configuration cfg = mappedStatement.getConfiguration();
        // 当前需要执行的SQL
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        // 改写为统计总数的SQL：这里需要区分数据库系统（如：MySQL、Oracle等）
        String countSQL = "select count(*) as total from (" + sql + ") $_paging";
        // 获取拦截方法参数
        Connection connection = (Connection)invocation.getArgs()[0];
        PreparedStatement ps = null;
        int total = 0;
        try{
            // 预编译统计总数SQL
            ps = connection.prepareStatement(countSQL);
            // 构建统计总数 BoundSql
            BoundSql countBoundSql = new BoundSql(cfg,countSQL,boundSql.getParameterMappings(),boundSql.getParameterObject());
            // 构建MyBatis的ParameterHandler用来设置总数SQL的参数
            ParameterHandler handler = new DefaultParameterHandler(mappedStatement,boundSql.getParameterObject(),countBoundSql);
            // 设置总数SQL参数
            handler.setParameters(ps);
            // 执行查询
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt("total");
            }
        }finally {
            // 这里不能关闭 Connection ，否则后续SQL就没法继续执行了
            if (ps != null){
                ps.close();
            }
        }
        System.out.println("总条数：" + total);
        return total;
    }

    /**
     * 获取分页参数
     */
    private PageParams getPageParams(Object parameterObject) {
        if (parameterObject == null) {
            return null;
        }
        PageParams pageParams = null;
        // 支持Map参数和MyBatis的@Param注解参数
        if (parameterObject instanceof Map){
            Map<String,Object> paramMap = (Map<String,Object>)parameterObject;
            Set<String> keySet = paramMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                Object value = paramMap.get(key);
                if (value instanceof PageParams){
                    return (PageParams)value;
                }
            }
        }else if (parameterObject instanceof PageParams){
            // 继承方式
            pageParams = (PageParams) parameterObject;
        }
        return pageParams;
    }

    /**
     * 判断SQL是否是 select 语句
     */
    private boolean checkSelect(String sql) {
        return sql.trim().toLowerCase().contains("select");
    }

    /**
     * 从代理对象中获得真实对象
     */
    private StatementHandler getUnProxyObject(Invocation invocation) {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        // 分离代理对象链
        Object object = null;
        while (metaStatementHandler.hasGetter(NAME_H)) {
            object = metaStatementHandler.getValue(NAME_H);
        }
        if (object == null) {
            return statementHandler;
        }
        return (StatementHandler) object;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.defaultPage = Integer.valueOf(properties.getProperty("default.page", "1"));
        this.defaultPageSize = Integer.valueOf(properties.getProperty("default.pageSize", "20"));
        this.defaultUseFlag = Boolean.valueOf(properties.getProperty("default.useFlag", "false"));
        this.defaultCheckFlag = Boolean.valueOf(properties.getProperty("default.checkFlag", "false"));
    }
}
