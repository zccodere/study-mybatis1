package com.zccoder.mybatis1.ch2.hello;

import com.zccoder.mybatis1.ch2.hello.mapper.RoleMapper;
import com.zccoder.mybatis1.ch2.hello.mapper.RoleMapperAnno;
import com.zccoder.mybatis1.ch2.hello.po.Role;

/**
 * <br>
 * 标题：启动类<br>
 * 描述：获取 Mapper 示例<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class MapperStart {

    public static void main(String[] args) {
//        showXml();
        showAnno();
    }

    private static void showAnno() {
        // 获取映射器 Mapper
        RoleMapperAnno roleMapper = MyBatisUtil.getSqlSessionFactoryByConf().openSession().getMapper(RoleMapperAnno.class);
        // 执行方法
        Role role = roleMapper.getRole(1L);
        // 打印角色名称
        System.out.println(role.getRoleName());
    }

    private static void showXml() {
        // 获取映射器 Mapper
        RoleMapper roleMapper = MyBatisUtil.getSqlSessionFactoryByXml().openSession().getMapper(RoleMapper.class);
        // 执行方法
        Role role = roleMapper.getRole(1L);
        // 打印角色名称
        System.out.println(role.getRoleName());
    }
}
