package com.zccoder.mybatis1.ch8.ssm.controller;

import com.zccoder.mybatis1.ch8.ssm.dao.po.RolePO;
import com.zccoder.mybatis1.ch8.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标题：角色控制器<br>
 * 描述：角色控制器<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role/{id}")
    public RolePO getRole(@RequestParam("id") int id){
        return roleService.findOne(id);
    }

}
