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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/other")
@SessionAttributes("errosMsg")
public class OtherController {
    
    @RequestMapping("/test1")
    public ModelAndView  test1(@RequestHeader("User-Agent") String userAgent,@CookieValue("JSESSIONID") String cookie) {
        System.out.println("User-Agent:"+userAgent);
        System.out.println("cookie:"+cookie);
        return null;
    }
    
    /*操作HttpSession
            默认情况下Model数据是放在request中共享的，如果想在session中共享---》SessionAttribute
     */
    @RequestMapping("/test2")
    public String  test2(Model model) {
        System.out.println("test2-------");
        model.addAttribute("errosMsg","报错信息");
        return "redirect:/abc.jsp";
    }
}
