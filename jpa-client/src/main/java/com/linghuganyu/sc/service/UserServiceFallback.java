package com.linghuganyu.sc.service;

import com.linghuganyu.sc.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Component  //千万别忘注解
public class UserServiceFallback implements UserService{
    @Override
    public MyPageImpl<User> list(UserVo vo) {

        System.out.println("列表熔断了");
        return null;
    }

    @Override
    public boolean add(User user) {
        System.out.println("添加熔断了");
        return false;
    }

    @Override
    public boolean delById(Integer id) {
        System.out.println("删除熔断了");
        return false;
    }

    @Override
    public List<Dept> deptList() {
        System.out.println("部门数据熔断了");
        return null;
    }

    @Override
    public List<Hobby> hobbyList() {
        System.out.println("爱好数据熔断了");
        return null;
    }
}
