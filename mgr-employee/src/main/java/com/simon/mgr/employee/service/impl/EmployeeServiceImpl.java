package com.simon.mgr.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simon.mgr.employee.bo.Employee;
import com.simon.mgr.employee.repo.EmployeeRepository;
import com.simon.mgr.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void register(String email, String password) {
		Employee employee = new Employee();
		employee.setEmail(email);
		employee.setPassword(password);
		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> listAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		employeeRepo.findAll().forEach(item -> employees.add((Employee) item));
		return employees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

}
