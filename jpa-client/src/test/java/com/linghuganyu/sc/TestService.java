package com.linghuganyu.sc;

import com.linghuganyu.sc.entity.MyPageImpl;
import com.linghuganyu.sc.entity.User;
import com.linghuganyu.sc.entity.UserVo;
import com.linghuganyu.sc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@SpringBootTest
public class TestService {

    @Autowired
    private UserService userService;

    @Test
    public void testList(){
        UserVo vo = new UserVo();
        MyPageImpl<User> list = userService.list(vo);
        for (Object o : list.getContent()) {
            System.out.println(o);
        }
    }
}
