package com.bigfong.webanno.dao;

import java.util.List;

import com.bigfong.webanno.domain.Employee;





/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:07:26
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface IEmployeeDAO {
    void save(Employee emp);

    void update(Employee emp);

    void delete(Long id);

    Employee get(Long id);

    List<Employee> listAll();

    Employee checkLogin(String username, String password);
}
