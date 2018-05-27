package com.zccoder.mybatis1.ch8.ssm.dao;

import com.zccoder.mybatis1.ch8.ssm.dao.po.UserPO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标题：表 t_user Mapper<br>
 * 描述：表 t_user Mapper<br>
 * 时间：2018/05/17<br>
 *
 * @author zc
 **/
@Repository
public interface UserMapper {

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
     * @param rowBounds 分页条件
     * @return PO 集合
     */
    List<UserPO> list(String userName, RowBounds rowBounds);


}
