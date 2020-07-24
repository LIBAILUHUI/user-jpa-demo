package com.linghuganyu.sc.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/24
 */
@Data
@Entity
@Table(name = "hg_house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;
}
