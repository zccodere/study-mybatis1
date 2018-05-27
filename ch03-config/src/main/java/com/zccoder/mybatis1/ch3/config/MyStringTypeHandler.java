package com.zccoder.mybatis1.ch3.config;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <br>
 * 标题：自定义 TypeHandler <br>
 * 描述：实现 TypeHandler 接口<br>
 * 使用 @MappedTypes 注解指定哪些 Java 类型被拦截
 * 使用 @MappedJdbcTypes 注解指定哪些 Jdbc 类型被拦截
 *
 * @author zc
 * @date 2018/03/16
 **/
@MappedTypes({String.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyStringTypeHandler implements TypeHandler<String> {

    private Logger log = Logger.getLogger(MyStringTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        log.info("使用我的自定义 TypeHandler");
        ps.setString(i,parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        log.info("使用我的自定义 TypeHandler,ResultSet列名获取字符串");
        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        log.info("使用我的自定义 TypeHandler,ResultSet下标获取字符串");
        return rs.getString(columnIndex);
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        log.info("使用我的自定义 TypeHandler,CallableStatement下标获取字符串");
        return cs.getString(columnIndex);
    }
}
