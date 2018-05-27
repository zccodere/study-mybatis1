package com.zccoder.mybatis1.ch2.hello.mapper;

import com.zccoder.mybatis1.ch2.hello.po.Role;
import org.apache.ibatis.annotations.Select;

/**
 * <br>
 * 标题：Role DAO<br>
 * 描述：使用注解生成 Mapper <br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public interface RoleMapperAnno {

    /**
     * 根据 ID 获取角色
     *
     * @param id
     * @return
     */
    @Select(value = "select id,role_name as roleName,note from t_role where id=#{id}")
    Role getRole(Long id);

}
