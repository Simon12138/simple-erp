package com.simon.mgr.employee.service;

import java.util.List;

import com.simon.mgr.employee.bo.Employee;

public interface EmployeeService {
	
	public void register(String email, String password);
	
	public List<Employee> listAllEmployees();
	
	public Employee createEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
}
