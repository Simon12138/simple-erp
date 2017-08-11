package com.simon.erp.api.employee.service;

import org.springframework.stereotype.Service;

import com.simon.erp.api.employee.ro.EmployeeRO;
import com.simon.erp.api.frw.service.ResourceObjectService;
import com.simon.erp.employee.bo.Employee;

@Service
public class EmployeeService extends ResourceObjectService<EmployeeRO, Employee> {

	public EmployeeService() {
		super(EmployeeRO.class, Employee.class);
	}

}
