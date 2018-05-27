package com.zccoder.mybatis1.ch2.hello.mapper;

import com.zccoder.mybatis1.ch2.hello.po.Role;

/**
 * <br>
 * 标题：Role DAO<br>
 * 描述：t_role 表 DAO 接口<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public interface RoleMapper {

    /**
     * 查询角色
     *
     * @param id
     * @return
     */
    Role getRole(Long id);

    /**
     * 新增角色
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 删除角色表的数据
     * @param id
     * @return
     */
    int deleteRole(Long id);

}
