package com.zccoder.mybatis1.ch7.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * 标题：编写自定义插件<br>
 * 描述：插件实例：限制查询语句返回记录数<br>
 * 时间：2018/05/10<br>
 *
 * @author zc
 **/
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})
})
public class QueryLimitPlugin implements Interceptor {

    private static final String H = "h";
    private static final String TARGET = "target";

    /** 数据库类型 */
    private String dbType;
    /** 限制查询返回行数 */
    private int limit;
    /** 限制表中间别名，避免表重名所以起得怪些 */
    private static final String LIMIT_TABLE_NAME = "limit_table_name_xxx";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 取出被拦截对象
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
        // 分离代理对象，从而形成多次代理，通过两次循环最原始的代理类，MyBatis使用的是JDK代理
        while (metaStatementHandler.hasGetter(H)){
            Object object = metaStatementHandler.getValue(H);
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        // 分离最后一个代理对象的目标类
        while (metaStatementHandler.hasGetter(TARGET)){
            Object object = metaStatementHandler.getValue(TARGET);
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        // 取出即将要执行的SQL
        String sql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");
        String limitSql;
        // 判断参数是不是MySQL数据库且SQL有没有被插件重写过（默认使用MySql）
        if (!sql.contains(LIMIT_TABLE_NAME)){
            // 去掉前后空格
            sql = sql.trim();
            // 将参数写入SQL
            limitSql = "select * from (" + sql + ") " + LIMIT_TABLE_NAME + " limit " + limit;
            // 重写要执行的SQL
            metaStatementHandler.setValue("delegate.boundSql.sql",limitSql);
        }
        // 调用原来对象的方法，进入责任链的下一层级
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        // 使用默认的MyBatis提供的类生成代理对象
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.dbType = properties.getProperty("dbType","MySQL");
        this.limit = Integer.valueOf(properties.getProperty("limit","50"));
    }
}
