package com.bigfong.webanno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigfong.jdbcweb.domain.Employee;
import com.bigfong.jdbcweb.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("employees", employeeService.listAll());
        return "jdbcweb/employee/list";
    }

    @RequestMapping("/input")
    public String input(Model model, Long id) {
        if (id != null) {
            model.addAttribute("employee", employeeService.get(id));
        } else {
            model.addAttribute("employee", new Employee());
        }
        return "jdbcweb/employee/input";
    }
    
    @RequestMapping("/saveOrUpdate")
    public String  saveOrUpdate(Model model,Employee e) {
        if (e.getId()==null) {
            employeeService.save(e);
        }else {
            employeeService.update(e);
        }
        
        return "redirect:list";
    }
    
    @RequestMapping("/delete")
    public String  delete(Long id) {
        if (id !=null) {
            employeeService.delete(id);
        }
        
        return "redirect:list";
    }

}
