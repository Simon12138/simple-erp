package com.simon.erp.system.service;

import com.simon.erp.rest.dto.EmployeeDTO;
import com.simon.erp.system.entity.Employee;

public interface EmployeeService {
	
	public Employee register(EmployeeDTO employeeDTO);
	
	public Employee load(Long id);
	
}
