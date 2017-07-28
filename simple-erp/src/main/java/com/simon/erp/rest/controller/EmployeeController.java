package com.simon.erp.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simon.erp.rest.dto.EmployeeDTO;
import com.simon.erp.system.entity.Employee;
import com.simon.erp.system.service.EmployeeService;

@RestController("/Employees/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Long> register(@RequestBody EmployeeDTO employeeDTO) {
		Employee employee = employeeService.register(employeeDTO);
		return new ResponseEntity<Long>(employee.getId(), HttpStatus.CREATED);
	}
}
