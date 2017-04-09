/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.context.*;
import org.springframework.ui.*;
import org.springframework.validation.*;

import java.util.*;
import javax.validation.*;

import com.websystique.springmvc.service.*;
import com.websystique.springmvc.model.*;
/**
 *
 * @author siede
 */
@Controller
@RequestMapping("/")
public class AppController {
    
	@Autowired
	EmployeeService service;
	@Autowired
	MessageSource messageSource;
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allemployees";
        }
        
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
        }
        
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {
        if (result.hasErrors()) {return "registration";}
        if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";}
		service.saveEmployee(employee);
		model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		return "success";
        }
        
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String ssn, ModelMap model) {
		Employee employee = service.findEmployeeBySsn(ssn);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
        }
        
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model, @PathVariable String ssn) {
		if (result.hasErrors()) {
			return "registration";}
		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";}
		service.updateEmployee(employee);
		model.addAttribute("success", "Employee " + employee.getName()	+ " updated successfully");
		return "success";
        }
        
	@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String ssn) {
		service.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
        }
}

