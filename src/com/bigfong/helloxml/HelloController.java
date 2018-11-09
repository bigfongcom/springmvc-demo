package com.bigfong.helloxml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/***********************************************************************   
*
* @author        bigfong
* @create-time   2018年11月7日 下午5:30:52
* @revision      $Id: 1.0  
*   
***********************************************************************/

public class HelloController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        System.out.println("hello");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/views/welcome.jsp");
        mv.addObject("msg", "你好hello spring-mvc");
        return mv;
    }

}
