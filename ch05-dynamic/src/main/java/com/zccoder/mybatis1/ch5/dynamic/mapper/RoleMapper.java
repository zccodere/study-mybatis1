package com.zccoder.mybatis1.ch5.dynamic.mapper;


import com.zccoder.mybatis1.ch5.dynamic.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标题：Role DAO<br>
 * 描述：Role DAO<br>
 *
 * @author zc
 * @date 2018/04/25
 **/
public interface RoleMapper {

    /**
     * if、where、trim
     * @param roleName
     * @return
     */
    List<Role> findRolesByRoleName(String roleName);

    /**
     * chose、when、otherwise
     * @param role
     * @return
     */
    List<Role> findRolesByRoleName(Role role);

    /**
     * set、test
     * @param role
     */
    void update(Role role);

    /**
     * foreach
     * @param ids
     * @return
     */
    List<Role> findByIds(List<Long> ids);

    /**
     * bind
     * @param roleName
     * @return
     */
    List<Role> findRoleByBind(@Param("_parameter")String roleName);

    /**
     * 多个bind
     * @param roleName
     * @param note
     * @return
     */
    List<Role> findRoleByBinds(@Param("roleName")String roleName,@Param("note")String note);
}
