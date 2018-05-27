package com.zccoder.mybatis1.ch8.ssm.service;

import com.zccoder.mybatis1.ch8.ssm.dao.po.UserPO;

import java.util.List;

/**
 * 标题：用户服务<br>
 * 描述：用户服务<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
public interface UserService {
    
    /**
     * 创建
     * @param userPO PO
     * @return 响应记录数
     */
    int insert(UserPO userPO);

    /**
     * 更新
     * @param userPO PO
     * @return 响应记录数
     */
    int update(UserPO userPO);

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
    UserPO findOne(Integer id);

    /**
     * 批量查询
     * @param userName 用户名称
     * @param start 开始条数
     * @param limit 每页条数
     * @return PO 集合
     */
    List<UserPO> list(String userName, int start,int limit);

}
