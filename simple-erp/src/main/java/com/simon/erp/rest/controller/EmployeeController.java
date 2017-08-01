package com.simon.erp.rest.controller;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simon.erp.rest.ro.EmployeeRO;
import com.simon.erp.system.entity.Employee;
import com.simon.erp.system.service.EmployeeService;

@RestController
@RequestMapping("/Employees/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private ModelMapper mapper = new ModelMapper();
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<EmployeeRO> get(@PathVariable Long id) {
		Employee employee = employeeService.load(id);
		EmployeeRO result = mapper.map(employee, EmployeeRO.class);
		return new ResponseEntity<EmployeeRO>(result, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<EmployeeRO[]> list() {
		List<Employee> employees = employeeService.list();
		List<EmployeeRO> results = new ArrayList<>();
		employees.forEach(item -> results.add(mapper.map(item, EmployeeRO.class)));
		return new ResponseEntity<EmployeeRO[]>(results.toArray(new EmployeeRO[] {}), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody EmployeeRO employeeRO) {
		Employee employee = mapper.map(employeeRO, Employee.class);
		Long id = employeeService.register(employee);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<Long> register(@RequestBody EmployeeRO employeeRO) {
		Employee employee = mapper.map(employeeRO, Employee.class);
		Long id = employeeService.register(employee);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Boolean> login(@RequestBody EmployeeRO employeeRO) {
		Employee employee = mapper.map(employeeRO, Employee.class);
		Boolean result = employeeService.login(employee);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
