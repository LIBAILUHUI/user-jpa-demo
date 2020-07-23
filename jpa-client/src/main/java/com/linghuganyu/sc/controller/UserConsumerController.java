package com.linghuganyu.sc.controller;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import com.linghuganyu.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserConsumerController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public MyPageImpl<User> list(UserVo vo){
        System.out.println("查询条件============="+vo);
        return userService.list(vo);
    }


    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        System.out.println(user);
        return userService.add(user);
    }

    @RequestMapping("delById")
    public boolean delById(Integer id){
        System.out.println(id);
        return userService.delById(id);
    }

}
