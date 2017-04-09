    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.websystique.springmvc.dao.*;
import com.websystique.springmvc.model.*;

import java.util.*;
/**
 *
 * @author siede
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
        
        @Override
	public Employee findById(int id) {
		return dao.findById(id);
        }
        
        @Override
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
        }
        
        @Override
	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if(entity!=null){
			entity.setName(employee.getName());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setSsn(employee.getSsn());
                }
        }
        
	@Override
	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
        }
        
        @Override
        public List<Employee> findAllEmployees() {
                    return dao.findAllEmployees();
        }
    
        @Override
	public Employee findEmployeeBySsn(String ssn) {
		return dao.findEmployeeBySsn(ssn);
        }
        
        @Override
	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeBySsn(ssn);
		return ( employee == null || ((id != null) && (employee.getId() == id)));
        }
}

