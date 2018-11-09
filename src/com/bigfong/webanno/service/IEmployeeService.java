package com.bigfong.webanno.service;

import java.util.List;

import com.bigfong.webanno.domain.Employee;



public interface IEmployeeService {
    void save(Employee emp);

    void update(Employee emp);

    void delete(Long id);

    Employee get(Long id);

    List<Employee> listAll();

    Employee login(String username, String password);
}
