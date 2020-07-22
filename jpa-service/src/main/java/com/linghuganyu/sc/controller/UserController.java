package com.linghuganyu.sc.controller;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import com.linghuganyu.sc.respository.UserRepository;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("testStatus")
    public String testStatus(){
        return "Hello cute";
    }

    @RequestMapping("testAdd")
    public String testAdd(){
        User user =new User();
        user.setName("蓝精灵");
        userRepository.save(user);
        return "success";
    }

    @RequestMapping("list")
    public MyPageImpl<User> list(@RequestBody UserVo vo){

        MyPageImpl<User> list = userService.list(vo);
        return list;
    }
}