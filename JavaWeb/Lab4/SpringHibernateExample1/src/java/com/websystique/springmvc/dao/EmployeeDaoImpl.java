/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.dao;

import org.springframework.stereotype.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

import java.util.*;

import com.websystique.springmvc.model.*;
/**
 *
 * @author siede
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
    
        @Override
	public Employee findById(int id) {
		return getByKey(id);
        }
        
        @Override
	public void saveEmployee(Employee employee) {
		persist(employee);
        }
        
        @Override
	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn =:ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
        }
        
        @Override
	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
        }
        
        @Override
	public Employee findEmployeeBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
        }
}

