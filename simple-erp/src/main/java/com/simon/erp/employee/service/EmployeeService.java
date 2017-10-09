package com.simon.erp.employee.service;

import java.util.List;

import com.simon.erp.employee.bo.Employee;

public interface EmployeeService {
	
	public void register(String email, String password);
	
	public List<Employee> listAllEmployees();
}
