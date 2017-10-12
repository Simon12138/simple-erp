package com.simon.mgr.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.mgr.employee.bo.Employee;
import com.simon.mgr.employee.bo.Role;
import com.simon.mgr.employee.repo.RoleRepository;
import com.simon.mgr.employee.service.EmployeeService;

@RestController("/")
public class TestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleRepository roleRepo;

	@RequestMapping("")
	public ResponseEntity<Role> test() {
		Employee employee = employeeService.listAllEmployees().get(0);
		Role role = roleRepo.findOne(1L);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
}
