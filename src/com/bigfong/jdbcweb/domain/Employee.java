package com.bigfong.jdbcweb.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull(message = "{employee.username.notnull}")
    @Size(max = 10, min = 4, message = "{employee.username.size}")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(max = 10, min = 4, message = "密码在4到10位之间")
    private String password;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "年龄最小值为18")
    @Max(value = 60, message = "年龄最大值为60")
    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
}
