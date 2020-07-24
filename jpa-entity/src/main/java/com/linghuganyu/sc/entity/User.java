package com.linghuganyu.sc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/22
 */
@Data
@Entity
@Table(name = "hg_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    private String username;

    private String password;

    private String name;

    private String email;

    private String telephone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer sex;

    private Integer state;

    private String code;


    @NotFound(action= NotFoundAction.IGNORE)
    @OneToOne(targetEntity = DriverCard.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",insertable = true,updatable = false,nullable = false)
    private DriverCard driverCard;

    //不要外键
    @ManyToOne(targetEntity = Dept.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true,foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Dept dept;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "uid",insertable = true,updatable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<House> houseList;


    @ManyToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY)
    @JoinTable(name = "hg_user_hobby",
        //描述本表与中间表的关系
        joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "uid",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            //描述中间表和对多表的关系
            inverseJoinColumns = {@JoinColumn(name = "hobby_id",referencedColumnName="id",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            uniqueConstraints = {@UniqueConstraint(name = "unit",columnNames = {"user_id","hobby_id"})}
    )
    private List<Hobby> hobbyList;
}
