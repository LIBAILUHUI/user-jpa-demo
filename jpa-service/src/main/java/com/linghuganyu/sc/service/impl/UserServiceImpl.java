package com.linghuganyu.sc.service.impl;

import com.linghuganyu.sc.entity.*;
import com.linghuganyu.sc.respository.DeptRepository;
import com.linghuganyu.sc.respository.HobbyRepository;
import com.linghuganyu.sc.respository.UserRepository;
import com.linghuganyu.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    /**
     * 分页列表
     * @param vo
     * @return
     */
    @Override
    public MyPageImpl<User> list(UserVo vo) {

        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //保存查询条件
                List<Predicate> list = new ArrayList<>();
                //根据username生成查询条件
                if(!StringUtils.isEmpty(vo.getUsername())){
                    Predicate username = criteriaBuilder.like(root.get("username"), "%" + vo.getUsername() + "%");
                    list.add(username);
                }
                if(null!=vo.getSex()){
                    Predicate sex = criteriaBuilder.equal(root.get("sex"), vo.getSex());
                    list.add(sex);
                }
                Predicate[] predicates = list.toArray(new Predicate[list.size()]);
                Predicate and = criteriaBuilder.and(predicates);
                return and;
            }
        };

        //分页，页码-1符合正常习惯
        Pageable pageable = PageRequest.of(vo.getNumber()-1,vo.getSize(), Sort.Direction.ASC,"uid");
        //Page<User> userPage = userRepository.findAll(pageable);
        //为了反序列化自定义的分页类
        //MyPageImpl<User> page = new MyPageImpl<>(userPage);

        Page<User> userPage = userRepository.findAll(specification, pageable);
        MyPageImpl<User> page = new MyPageImpl<>(userPage);
        return page;
    }

    @Override
    public boolean add(User user) {


        try {
            User user1 = userRepository.saveAndFlush(user);
            //判断添没添加上
            if(user1.getUid()>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delById(Integer id) {

        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    //获取所有部门
    @Override
    public List<Dept> deptList() {
        return deptRepository.findAll();
    }

    //获取所有爱好
    @Override
    public List<Hobby> hobbyList() {
        return hobbyRepository.findAll();
    }


}
