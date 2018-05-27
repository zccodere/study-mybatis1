package com.zccoder.mybatis1.ch8.ssm.service.impl;

import com.zccoder.mybatis1.ch8.ssm.dao.UserMapper;
import com.zccoder.mybatis1.ch8.ssm.dao.po.UserPO;
import com.zccoder.mybatis1.ch8.ssm.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 标题：用户服务实现<br>
 * 描述：用户服务实现<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(UserPO userPO) {
        return userMapper.insert(userPO);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public int update(UserPO userPO) {
        return userMapper.update(userPO);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public UserPO findOne(Integer id) {
        return userMapper.findOne(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public List<UserPO> list(String userName, int start, int limit) {
        return userMapper.list(userName,new RowBounds(start,limit));
    }
}
