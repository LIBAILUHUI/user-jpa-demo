package com.linghuganyu.sc.entity;

import lombok.Data;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Data
public class UserVo extends User{

    private Integer number=1;
    private Integer size=3;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public UserVo() {
    }

    public UserVo(Integer number, Integer size) {
        this.number = number;
        this.size = size;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "number=" + number +
                ", size=" + size +
                '}'+super.toString();
    }
}
