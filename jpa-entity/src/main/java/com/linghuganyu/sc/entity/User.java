package com.linghuganyu.sc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

}
