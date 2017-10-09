package com.simon.erp.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simon.erp.employee.bo.Employee;
import com.simon.erp.employee.repo.EmployeeRepository;
import com.simon.erp.employee.service.EmployeeService;

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
		employeeRepo.findAll().forEach(item -> employees.add(item));
		return employees;
	}

}
