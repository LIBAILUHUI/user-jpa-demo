package com.linghuganyu.sc.service;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Component  //千万别忘注解
public class UserServiceFallback implements UserService{
    @Override
    public MyPageImpl<User> list(UserVo vo) {
        return null;
    }
}
