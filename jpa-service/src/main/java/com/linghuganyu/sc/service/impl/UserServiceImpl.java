package com.linghuganyu.sc.service.impl;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import com.linghuganyu.sc.respository.UserRepository;
import com.linghuganyu.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * 分页列表
     * @param vo
     * @return
     */
    @Override
    public MyPageImpl<User> list(UserVo vo) {
        Pageable pageable = PageRequest.of(vo.getNumber()-1,vo.getSize(), Sort.Direction.ASC,"uid");
        PageImpl<User> userPage = (PageImpl<User>)userRepository.findAll(pageable);
        //为了反序列化自定义的分页类
        MyPageImpl<User> page = new MyPageImpl<>(userPage);
        return page;
    }
}
