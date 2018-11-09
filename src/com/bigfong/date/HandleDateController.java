package com.bigfong.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bigfong.vo.User;

/***********************************************************************
 *
 * @author bigfong
 * @create-time 2018年11月8日 下午2:54:29
 * @revision $Id: 1.0
 * 
 ***********************************************************************/

@Controller
@RequestMapping("/date")
public class HandleDateController {

    // 把请求参数封装成Date类型
    @RequestMapping("/test1")
    public ModelAndView test1(@DateTimeFormat(pattern = "yyyy-MM-dd") Date d) {
        System.out.println(d);
        return null;
    }

    // 把请求参数封装成Date类型
    @RequestMapping("/test2")
    private ModelAndView test2(User u) {
        System.out.println(u);
        return null;

    }

    // 如果不想每次都在Date类开上添加@DateTimeFormat,则要把vo实体类中@DateTimeFormat这个去掉
    /*
     * public void initBinderDateType(WebDataBinder binder) { SimpleDateFormat sdf = new
     * SimpleDateFormat(); sdf.applyPattern("yyyy-MM--dd");
     * binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true)); }
     */

    @RequestMapping("/test3")
    @ResponseBody
    public User test3() {
        User u = new User();
        u.setUsername("bigfong");
        u.setAge(17);
        u.setHiredate(new Date());
        return u;
    }
}
