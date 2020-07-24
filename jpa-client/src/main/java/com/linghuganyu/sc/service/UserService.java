package com.linghuganyu.sc.service;

import com.linghuganyu.sc.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "jpa-service",fallback = UserServiceFallback.class)
public interface UserService {

    //分页列表
    @RequestMapping("user/list")
    MyPageImpl<User> list(@RequestBody UserVo vo);

    @RequestMapping("user/add")
    public boolean add(@RequestBody User user);

    @RequestMapping("user/delById")
    public boolean delById(@RequestParam("id") Integer id);

    @RequestMapping("user/deptList")
    public List<Dept> deptList();

    @RequestMapping("user/hobbyList")
    public List<Hobby> hobbyList();
}
