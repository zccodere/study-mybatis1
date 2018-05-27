package com.zccoder.mybatis1.ch8.ssm.service;

import com.zccoder.mybatis1.ch8.ssm.dao.po.RolePO;

import java.util.List;

/**
 * 标题：角色服务<br>
 * 描述：角色服务<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
public interface RoleService {

    /**
     * 创建
     * @param rolePO PO
     * @return 响应记录数
     */
    int insert(RolePO rolePO);

    /**
     * 更新
     * @param rolePO PO
     * @return 响应记录数
     */
    int update(RolePO rolePO);

    /**
     * 删除
     * @param id 主键
     * @return 响应记录数
     */
    int delete(Integer id);

    /**
     * 单个查询
     * @param id 主键
     * @return PO
     */
    RolePO findOne(Integer id);

    /**
     * 批量查询
     * @param roleName 角色名称
     * @param start 开始条数
     * @param limit 每页条数
     * @return PO 集合
     */
    List<RolePO> list(String roleName,int start,int limit);

}
