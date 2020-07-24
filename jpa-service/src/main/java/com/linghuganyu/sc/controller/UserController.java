package com.linghuganyu.sc.controller;

import com.linghuganyu.sc.entity.*;
import com.linghuganyu.sc.respository.UserRepository;
import com.linghuganyu.sc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Api(
        value = "用户服务端",
        tags = {"用户","管理"}
)
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试用,检查服务端状态是否正常",httpMethod = "GET")
    @ApiResponse(code = 200, message = "返回Hello cute测试正常", response = String.class)
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

    @ApiOperation(value = "获取用户列表,分页，条件查询",response = MyPageImpl.class,httpMethod = "GET")
    //列表，分页，条件查询
    @RequestMapping("list")
    @ApiResponse(code = 200,message = "return type:MyPageImpl<User>",response = MyPageImpl.class)
    public MyPageImpl<User> list(@ApiParam(name = "vo",value ="vo类") @RequestBody UserVo vo){
        System.out.println("提供者这边的参数"+vo);
        MyPageImpl<User> list = userService.list(vo);
        return list;
    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        return userService.add(user);
    }

    @RequestMapping("delById")
    public boolean delById(Integer id){
        return userService.delById(id);
    }

    @RequestMapping("deptList")
    public List<Dept> deptList(){
        List<Dept> deptList= userService.deptList();
        return deptList;
    }

    @RequestMapping("hobbyList")
    public List<Hobby> hobbyList(){
        List<Hobby> hobbyList= userService.hobbyList();
        return hobbyList;
    }

}
