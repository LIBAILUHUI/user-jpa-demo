package com.linghuganyu.sc.service;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "jpa-service",fallback = UserServiceFallback.class)
public interface UserService {

    //分页列表
    @RequestMapping(value = "user/list")
    MyPageImpl<User> list(@RequestBody UserVo vo);
}
