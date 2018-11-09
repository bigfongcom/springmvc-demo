package com.bigfong.webanno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigfong.webanno.dao.IEmployeeDAO;
import com.bigfong.webanno.domain.Employee;
import com.bigfong.webanno.service.IEmployeeService;
import com.bigfong.webanno.util.UserContext;


@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO dao;

	public void save(Employee emp) {
	    System.out.println(emp);
		dao.save(emp);
	}

	public void update(Employee emp) {
		dao.update(emp);
	}

	public void delete(Long id) {
		dao.delete(id);
	}
	
	@Transactional(readOnly=true)
	public Employee get(Long id) {
		return dao.get(id);
	}

	@Transactional(readOnly=true)
	public List<Employee> listAll() {
		return dao.listAll();
	}

	@Transactional(readOnly = true)
	public Employee login(String username, String password) {
		Employee current = dao.checkLogin(username, password);
		if (current == null) {
			throw new RuntimeException("账号或密码错误!");
		}
		UserContext.setCurrentUser(current);
		return current;
	}
}
