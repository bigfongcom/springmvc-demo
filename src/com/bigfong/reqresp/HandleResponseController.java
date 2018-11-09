package com.bigfong.reqresp;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/***********************************************************************   
* 处理响应
* @author        bigfong
* @create-time   2018年11月7日 下午9:25:55
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Controller
@RequestMapping("/response")
public class HandleResponseController {
    
    //返回void类型，此时可以把Controller方法当做Servlet来使用
    @RequestMapping("/test1")
    public void  test1(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //请求转发
        request.getRequestDispatcher("").forward(request, response);
        //URL重定向
        response.sendRedirect("");
        //设置共享数据
        request.setAttribute("", "");
        //输出JSON格式
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println("");
    }
    
    //返回void:文件下载
    @RequestMapping("/test2")
    public void  test2(OutputStream out) throws IOException{
        Files.copy(Paths.get("D:/Java/abc.rar"), out);
    }
    
    //返回ModelAndView
    @RequestMapping("/test3")
    public ModelAndView test3() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "返回ModelAndView");//设置共享数据的key和value
        mv.addObject("you are the best");//设置共享数据的value，此时会把value类型的首字母作为key,这里是字符串(String)对应则为:string
        mv.setViewName("result");
        return mv;
    }
    
    //返回String，逻辑视图名称，此时需要结合Model类型的参数一起使用
    @RequestMapping("/test4")
    public String test4(Model model) {
        model.addAttribute("msg", "返回ModelAndView-test4");//设置共享数据的key和value
        model.addAttribute("you are the best-test4");
        return "result";
    }
    
    //请求转发,浏览器地址栏不改变，可以共享请求中的数据
    //原理： request.getRequestDispatcher("").forward(request, response);
    @RequestMapping("/test5")
    public String test5(Model model) {
        return "forward:/index.html";
    }
    
   //URL重定向,浏览器地址栏会改变，不可以共享请求中的数据
    //原理:response.sendRedirect("");
    @RequestMapping("/test6")
    public String test6(Model model) {
        return "redirect:/index.html";
    }
    
    
    //普通方式，数据会显式地显示在地址栏中
    //flash方式，数据不会显式地显示在地址栏中，只能从Controller重定向到Controller，原理:httpSession
    @RequestMapping("/a")
    public String a(RedirectAttributes ra) {
        ra.addAttribute("msg1", "普通方式");
        ra.addFlashAttribute("msg2", "flash方式");
        return "redirect:b";
    }
    
    @RequestMapping("/b")
    public ModelAndView b(String msg1,@ModelAttribute("msg2")String msg2) {
        System.out.println("msg1:"+msg1);
        System.out.println("msg2:"+msg2);
        return null;
    }
}
