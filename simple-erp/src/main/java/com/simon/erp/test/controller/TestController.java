package com.simon.erp.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.erp.common.BusinessObject;
import com.simon.erp.system.entity.Employee;
import com.simon.erp.system.service.EmployeeService;

@RestController
public class TestController {
	
	private final String MARK = "---------------";
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public void testStart() {
		System.out.println(MARK + "Start Successfully." + MARK);
	}
	
	@RequestMapping("/Employees")
	public BusinessObject testEmployee() {
		Employee employee = employeeService.load(2L);
		 return employee;
	}
}
