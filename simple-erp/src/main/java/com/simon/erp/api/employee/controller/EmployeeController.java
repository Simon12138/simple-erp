package com.simon.erp.api.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simon.erp.api.employee.ro.EmployeeRO;
import com.simon.erp.employee.bo.Employee;
import com.simon.erp.employee.service.EmployeeService;


@RestController
@RequestMapping("/Employees/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private final static DozerBeanMapper dozerMapper = new DozerBeanMapper();
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<EmployeeRO[]> list() {
		List<Employee> employees = employeeService.listAllEmployees();
		List<EmployeeRO> results = new ArrayList<>();
		employees.forEach(item -> results.add(dozerMapper.map(item, EmployeeRO.class)));
		return new ResponseEntity<EmployeeRO[]>(results.toArray(new EmployeeRO[] {}), HttpStatus.OK);
	}
}
