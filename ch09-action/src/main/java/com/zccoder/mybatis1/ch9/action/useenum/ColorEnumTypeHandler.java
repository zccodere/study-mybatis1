package com.zccoder.mybatis1.ch9.action.useenum;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 标题：在映射中使用枚举类<br>
 * 描述：自定义枚举类<br>
 * 时间：2018/05/25<br>
 *
 * @author zc
 **/
public class ColorEnumTypeHandler implements TypeHandler<Color> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Color color, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,color.getCode());
    }

    @Override
    public Color getResult(ResultSet rs, String columnName) throws SQLException {
        int result = rs.getInt(columnName);
        return Color.getEnumByCode(result);
    }

    @Override
    public Color getResult(ResultSet rs, int columnIndex) throws SQLException {
        int result = rs.getInt(columnIndex);
        return Color.getEnumByCode(result);
    }

    @Override
    public Color getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int result = cs.getInt(columnIndex);
        return Color.getEnumByCode(result);
    }
}
