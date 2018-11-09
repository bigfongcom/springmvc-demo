package com.bigfong.json;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigfong.vo.User;

/***********************************************************************   
*
* @author        bigfong
* @create-time   2018年11月8日 下午2:38:39
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Controller
@RequestMapping("/json")
public class HandleJsonController {
    /*
         处理JSON的注解：
         @ResponseBody:处理响应，把对象转换为JSON字符串
                     贴在方法上，只针对当前方法做JSON处理
                     贴在类上：会对当前类所有方法做JSON处理          
                     
       @RestController = @Controller + @ResponseBody
       RequestBody:处理请求，用于读取HTTP请求的内容，把JSON格式的请求封装成对象
       
       一般的请求的数据格式:
        application/x-www-form-urlencoded: 传统的key-value格式,处理起来非常方便. 不需要RequestBody都可以,贴上也可以.
        application/multipart:文件上传的请求,SpringMVC装设设计模式,.既能处理文件上传,也能处理普通表单数据.
        application/json:       参数是JSON格式的,此时必须使用RequestBody.
     */
    //把单个对象/Map转换为json格式
    @RequestMapping("/test1")
    @ResponseBody
    public User test1() {
        User user = new User();
        user.setUsername("bigfong");
        user.setAge(30);
        
        return user;
        
    }
    
    //把多个对象转换为JSON
    @RequestMapping("/test2")
    @ResponseBody
    public List<User> test2() {
        User user = new User();
        user.setUsername("bigfong");
        user.setAge(30);
        
        return Arrays.asList(user,user,user);
        
    }
    
     //返回一个String，把返回的字符串不会当做是逻辑视图名称，而是JSON格式的数据
    //解决中文乱码produces="application/json;charset=utf-8"
    @RequestMapping(value="/test3",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String test3() {
        return "success,解决中文乱码";
        
    }
}
