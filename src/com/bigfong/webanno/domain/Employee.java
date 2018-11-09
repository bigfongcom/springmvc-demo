package com.bigfong.webanno.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/***********************************************************************
 *
 * @author fenfenglee
 * @create-time 2018年10月29日 下午10:09:01
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

@Data
public class Employee {
    private Long id;

    private String username;

    private String password;

    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")//前台--->后台
    private Date hiredate;
}
