package com.linghuganyu.sc.service;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import org.springframework.data.domain.Page;

public interface UserService {
    MyPageImpl<User> list(UserVo vo);
}
