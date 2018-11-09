package com.bigfong.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/***********************************************************************   
*
* @author        bigfong
* @create-time   2018年11月8日 上午12:02:32
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Data
public class User {
    private Long id;
    private String username;
    private Integer age;
    
    //@DateTimeFormat(pattern = "yyyy-MM-dd")//前台--->后台
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//后台--->前台
    private Date hiredate;
}
