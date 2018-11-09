package com.bigfong.jdbcweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigfong.jdbcweb.domain.Employee;
import com.bigfong.jdbcweb.service.IEmployeeService;

@Controller
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;

    
    
    @RequestMapping("/login")
    public String  login(String username,String password,HttpSession session) {
        try {
            Employee emp = employeeService.login(username, password);
            /*if (emp == null) {
                session.setAttribute("errorMsg", "账号或密码错误!");
                return "redirect:login.jsp";
            }*/
            
            return "redirect:employee/list";
        } catch (Exception e) {
            session.setAttribute("errorMsg",e.getMessage());
            return "redirect:login.jsp";
        }
        
    }
    
    

}
