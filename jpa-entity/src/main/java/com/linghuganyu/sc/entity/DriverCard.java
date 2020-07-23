package com.linghuganyu.sc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Administrator
 * @description TODO
 * @date 2020/7/23
 */
@Data
@Entity
@Table(name = "hg_drivercard")
public class DriverCard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //驾驶证类型
    private String cardType;

    //过期时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireDate;
}
