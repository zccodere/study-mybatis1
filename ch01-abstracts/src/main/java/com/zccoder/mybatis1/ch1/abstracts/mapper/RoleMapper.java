package com.zccoder.mybatis1.ch1.abstracts.mapper;

import com.zccoder.mybatis1.ch1.abstracts.po.Role;

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
     * 根据 ID 获取角色
     *
     * @param id
     * @return
     */
    Role getRole(Long id);

}
