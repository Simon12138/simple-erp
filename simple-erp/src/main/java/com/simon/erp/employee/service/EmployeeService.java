package com.simon.erp.employee.service;

import java.util.List;

import com.simon.erp.employee.bo.Employee;

public interface EmployeeService {
	
	public Long register(Employee employee);
	
	public boolean login(Employee employee);
	
	public List<Employee> list();
	
}
