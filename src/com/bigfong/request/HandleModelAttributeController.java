package com.bigfong.request;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/modelattribute")
public class HandleModelAttributeController {
    
    
    //==================================
    /*
      ModelAttribute注解
         1.给共享的model数据设置key名，贴在形参上，也可以贴在方法上
                       针对复合类型（非简单类型）参数，缺省情况下就会放在model中（共享）,缺省的key就是类型首字母小写
                       也可以在参数上贴ModelAttribute,设置一个model的key名
         2.可以标注一个非请求处理的方法，被标注的方法，每次在请求处理之前都会被优先执行，一般用于存放多个请求需要共享的数据        
     */
    
    @RequestMapping("/test1")
    public String test1(User u) {
        System.out.println(u);
        return "result";
    }
    
    @RequestMapping("/test2")
    public String test2(@ModelAttribute("myUser")User u) {
        System.out.println(u);
        return "result";
    }
    
    //当Controller方法返回一个对象的时候，缺省会把当前请求的URL作为逻辑视图名称，并共享当前返回对象
    //一般地返回一个JavaBean对象的时候，用于JSON操作,必有依赖JSON库(jacksion)
    @RequestMapping("/test3")
    @ResponseBody
    public User test3(@ModelAttribute("myUser")User u) {
        System.out.println(u);
        return u;
    }
    
  //可以标注一个非请求处理的方法，被标注的方法，每次在请求处理之前都会被优先执行，一般用于存放多个请求需要共享的数据
    @ModelAttribute
    public void abc(Model model) {
        System.out.println("abc");
    }
}
