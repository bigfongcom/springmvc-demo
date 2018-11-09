package com.bigfong.request;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigfong.vo.FormBean;
import com.bigfong.vo.User;



/***********************************************************************   
*
* @author        bigfong
* @create-time   2018年11月7日 下午10:10:51
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Controller
@RequestMapping("/request")
public class HandleRequesController {
    
    @Autowired
    private ServletContext servletContext;
    
    @RequestMapping("/test1")
    public void test1(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
        
        System.out.println(request);
        System.out.println(request.getParameter("username"));
        System.out.println(response);
        System.out.println(session);
        System.out.println(this.servletContext);
    }
    
    
    //获取请求参数，保证请求参数和Controller方法形参（入参）同名
    @RequestMapping("/test2")
    public void test2(String username,int age) {        
        System.out.println(username);
        System.out.println(age);
    }
    
  //如果请求参数名称和形参名称不同--->RequestParam
    @RequestMapping("/test3")
    public void test3(@RequestParam("name")String username,@RequestParam(value = "age",required=false)Integer age) {        
        System.out.println(username);
        System.out.println(age);
    }
    
    //RESTfull风格传参
    @RequestMapping("/delete/{id}")
    public void test4(@PathVariable("id")Long id) {        
        System.out.println(id);
    }
    
    //接受一个参数有多个值的情况
    //批量删除  /batchDelete1?ids=1&ids=20&ids=3
    //          /batchDelete1?ids[0]=1&ids[1]=20&ids[2]=3
    //使用数组:可以直接接收
    @RequestMapping("/batchDelete1")
    public void test5(Long[] ids) {        
        System.out.println(Arrays.asList(ids));
    }
  
    
    //接受一个参数有多个值的情况
    //批量删除  /batchDelete3?ids=1&ids=20&ids=3
    //使用List: test6(List<Long> ids)不能直接接收,但可以在一个对象中有一个集合
    @RequestMapping("/batchDelete2")
    public void test6(FormBean fb) {        
        System.out.println(fb.getIds());
    }
    
    //操作一个参数有多个值的情况，一般直接使用数组接收就可以，或者使用JavaBean对象来封装数据
    
    //把数据封装到JavaBean对象中
    //   /user?username=111&id=10&age=30
    @RequestMapping("/user")
    public void test7(User u) {        
        System.out.println(u);
    }
}
