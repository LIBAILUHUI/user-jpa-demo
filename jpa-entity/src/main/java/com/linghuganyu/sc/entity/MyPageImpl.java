package com.linghuganyu.sc.entity;

import lombok.Data;
import org.springframework.data.domain.PageImpl;

import java.util.List;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Data
public class MyPageImpl<T> {

    private long totalElements = 0;

    private List<T> content = null;

    private Integer totalPages = 0;

    private Integer number = 0;

    private Integer size = 3;

    public MyPageImpl(PageImpl<T> pil) {
        this.totalElements = pil.getTotalElements();
        this.content = pil.getContent();
        this.totalPages = pil.getTotalPages();
        this.number = pil.getNumber();
        this.size = pil.getSize();
    }


    //客户端调服务端时候需要反序列化，jpa的Page接口和PageImpl都没有提供无参构造，所以自定义
    public MyPageImpl() {
    }
}
