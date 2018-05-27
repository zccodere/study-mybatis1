package com.zccoder.mybatis1.ch8.ssm.dao;

import com.zccoder.mybatis1.ch8.ssm.dao.po.RolePO;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标题：表 t_role Mapper<br>
 * 描述：表 t_role Mapper<br>
 * 时间：2018/05/17<br>
 *
 * @author zc
 **/
@Repository
public interface RoleMapper {
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
     * @param rowBounds 分页条件
     * @return PO 集合
     */
    List<RolePO> list(String roleName,RowBounds rowBounds);

}
