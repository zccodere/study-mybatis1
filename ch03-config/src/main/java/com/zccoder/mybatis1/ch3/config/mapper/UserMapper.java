package com.zccoder.mybatis1.ch3.config.mapper;

import com.zccoder.mybatis1.ch3.config.po.User;

/**
 * <br>
 * 标题：User DAO<br>
 * 描述：t_user 表 DAO 接口<br>
 *
 * @author zc
 * @date 2018/04/19
 **/
public interface UserMapper {

    /**
     * 查询角色
     *
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 新增角色
     * @param role
     * @return
     */
    int insertUser(User role);


}
