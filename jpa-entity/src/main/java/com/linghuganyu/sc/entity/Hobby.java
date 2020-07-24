package com.linghuganyu.sc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/24
 */
@Data
@Entity
@Table(name = "hg_hobby")
public class Hobby implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
