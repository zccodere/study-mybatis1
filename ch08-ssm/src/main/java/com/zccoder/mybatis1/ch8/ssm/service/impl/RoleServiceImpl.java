package com.zccoder.mybatis1.ch8.ssm.service.impl;

import com.zccoder.mybatis1.ch8.ssm.dao.RoleMapper;
import com.zccoder.mybatis1.ch8.ssm.dao.po.RolePO;
import com.zccoder.mybatis1.ch8.ssm.service.RoleService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标题：角色服务实现<br>
 * 描述：角色服务实现<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert(RolePO rolePO) {
        return roleMapper.insert(rolePO);
    }

    @Override
    public int update(RolePO rolePO) {
        return roleMapper.update(rolePO);
    }

    @Override
    public int delete(Integer id) {
        return roleMapper.delete(id);
    }

    @Override
    public RolePO findOne(Integer id) {
        return roleMapper.findOne(id);
    }

    @Override
    public List<RolePO> list(String roleName, int start, int limit) {
        return roleMapper.list(roleName,new RowBounds(start,limit));
    }
}
