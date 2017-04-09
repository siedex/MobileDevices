/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.service;

import java.util.*;

import com.websystique.springmvc.model.Employee;
/**
 *
 * @author siede
 */
public interface EmployeeService {
	Employee findById(int id);
        
	void saveEmployee(Employee employee);
        
	void updateEmployee(Employee employee);
        
	void deleteEmployeeBySsn(String ssn);
        
	List<Employee> findAllEmployees(); 
        
	Employee findEmployeeBySsn(String ssn);
        
	boolean isEmployeeSsnUnique(Integer id, String ssn);
}

