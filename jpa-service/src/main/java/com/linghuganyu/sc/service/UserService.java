package com.linghuganyu.sc.service;

import com.linghuganyu.sc.entity.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    //分页条件查询
    MyPageImpl<User> list(UserVo vo);

    //添加
    boolean add(User user);

    //单删，根据id删除
    boolean delById(Integer id);

    //部门列表
    List<Dept> deptList();

    //爱好列表
    List<Hobby> hobbyList();
}
