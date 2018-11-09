package com.bigfong.helloanno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/***********************************************************************   
*
* @author        bigfong
* @create-time   2018年11月7日 下午5:30:52
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Controller
public class HelloController{

    @RequestMapping("hello")
    public ModelAndView sayHello() {
        System.out.println("hello-anno");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/views/welcome.jsp");
        mv.addObject("msg", "你好hello spring-mvc-anno");
        return mv;
    }

}
