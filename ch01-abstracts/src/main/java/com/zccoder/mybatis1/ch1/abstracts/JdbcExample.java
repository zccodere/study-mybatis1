package com.zccoder.mybatis1.ch1.abstracts;

import com.zccoder.mybatis1.ch1.abstracts.po.Role;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <br>
 * 标题：传统的 JDBC 编程<br>
 * 描述：使用 JDBC 编程的例子<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class JdbcExample {

    public static void main(String[] args) {
        JdbcExample example = new JdbcExample();
        Role role = example.getRole(1L);
        System.out.printf("role_name => " + role.getRoleName());
    }

    public Role getRole(Long id) {
        Connection connection = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 操作 Connection，打开 Statement 对象
            ps = connection.prepareStatement("select id,role_name,note from t_role where id = ?");
            ps.setLong(1,id);
            // 通过 Statement 执行 SQL，返回结果到 ResultSet 对象
            rs = ps.executeQuery();
            // 通过 ResultSet 读取数据，然后通过代码转化为具体的 POJO 对象
            while (rs.next()){
                Long roleId = rs.getLong("id");
                String roleName = rs.getString("role_name");
                String note = rs.getString("note");
                Role role = new Role();
                role.setId(id);
                role.setRoleName(roleName);
                role.setNote(note);
                return role;
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            this.close(rs,ps,connection);
        }
        return null;
    }
    private Connection getConnection(){
        // 使用 JDBC 编程需要连接数据库，注册驱动和数据库信息
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mybatis1?characterEncoding=utf8";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }
        return connection;
    }
    private void close(ResultSet rs,Statement stmt,Connection connection){
        // 关闭数据库相关资源
        try {
            if (rs != null && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            if (stmt != null && !stmt.isClosed()){
                stmt.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE,null,e);
        }
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
