package com.zccoder.mybatis1.ch4.mappers.mapper;

import com.zccoder.mybatis1.ch4.mappers.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 标题：Role DAO<br>
 * 描述：Role DAO<br>
 *
 * @author zc
 * @date 2018/04/25
 **/
public interface RoleMapper {

    /**
     * 单个参数传递
     * @param id
     * @return
     */
    Role getRole(Long id);

    /**
     * 【禁止使用】使用map传递参数
     * @param params
     * @return
     */
    List<Role> findRoleByMap(Map<String,String> params);

    /**
     * 【恰当使用】使用注解方式传递参数
     * @param roleName
     * @param note
     * @return
     */
    List<Role> findRoleByAnnotation(@Param("roleName")String roleName,@Param("note")String note);

    /**
     * 【推荐使用】使用JavaBean传递参数
     * @param role
     * @return
     */
    List<Role> findRoleByParams(Role role);

    /**
     * 插入
     * @param role
     */
    void insert(Role role);

    /**
     * 更新
     * @param role
     */
    void update(Role role);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);
}
