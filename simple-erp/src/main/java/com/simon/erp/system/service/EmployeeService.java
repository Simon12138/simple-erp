package com.simon.erp.system.service;

import java.util.List;

import com.simon.erp.system.entity.Employee;

public interface EmployeeService {
	
	public Long register(Employee employee);
	
	public boolean login(Employee employee);
	
	public Employee load(Long id);
	
	public List<Employee> list();
	
}
