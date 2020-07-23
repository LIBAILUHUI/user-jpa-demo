package com.linghuganyu.sc.service;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import org.springframework.data.domain.Page;

public interface UserService {
    //分页条件查询
    MyPageImpl<User> list(UserVo vo);

    //添加
    boolean add(User user);

    //单删，根据id删除
    boolean delById(Integer id);
}
