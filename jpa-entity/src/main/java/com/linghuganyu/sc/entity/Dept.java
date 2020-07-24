package com.linghuganyu.sc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Administrator
 * @description 部门
 * @date 2020/7/24
 */
@Data
@Entity
@Table(name = "hg_dept")
public class Dept implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
