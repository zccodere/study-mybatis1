package com.zccoder.mybatis1.ch3.config;

import com.zccoder.mybatis1.ch3.config.enums.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 标题：自定义枚举类型typeHandler<br>
 * 描述：性别枚举转换<br>
 *
 * @author zc
 * @date 2018/04/19
 **/
public class SexEnumTypeHandler implements TypeHandler<Sex>{

    @Override
    public void setParameter(PreparedStatement ps, int index, Sex sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(index,sex.getId());
    }

    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        return Sex.getSex(id);
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        return Sex.getSex(id);
    }
}
