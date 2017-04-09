/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.*;

import java.util.*;
/**
 *
 * @author siede
 */
public interface EmployeeDao {
	Employee findById(int id);
        
	void saveEmployee(Employee employee);
        
	void deleteEmployeeBySsn(String ssn);
        
	List<Employee> findAllEmployees();
        
	Employee findEmployeeBySsn(String ssn);
}

