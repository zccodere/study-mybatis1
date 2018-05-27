package com.zccoder.mybatis1.ch2.hello;

import com.zccoder.mybatis1.ch2.hello.mapper.RoleMapper;
import com.zccoder.mybatis1.ch2.hello.po.Role;
import org.apache.ibatis.session.SqlSession;

/**
 * <br>
 * 标题：启动类<br>
 * 描述：完成新增角色和删除编号为1L的角色对象<br>
 *
 * @author zc
 * @date 2018/03/15
 **/
public class HelloStart {

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("testName");
            role.setNote("testNote");
            // 新增角色
            roleMapper.insertRole(role);
            // 删除角色
            roleMapper.deleteRole(1L);
            sqlSession.commit();
        } catch (Exception e){
            System.err.println(e.getMessage());
            sqlSession.rollback();
        }finally {
            if (sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
