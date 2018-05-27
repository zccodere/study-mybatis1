package com.zccoder.mybatis1.ch1.abstracts;

import com.zccoder.mybatis1.ch1.abstracts.mapper.RoleMapper;
import com.zccoder.mybatis1.ch1.abstracts.po.Role;
import org.apache.ibatis.session.SqlSession;

/**
 * <br>
 * 标题：使用 MyBatis 编程<br>
 * 描述：使用 MyBatis 编程的例子<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class MyBatisExample {

    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(1L);
        System.out.println("role_name => " + role.getRoleName());
        sqlSession.close();
    }
}
