package com.simon.erp.system.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simon.erp.rest.dto.EmployeeDTO;
import com.simon.erp.system.entity.Employee;
import com.simon.erp.system.repository.EmployeeRepository;
import com.simon.erp.system.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Employee register(EmployeeDTO employeeDTO) {
		if (!isExist(employeeDTO)) {
			Employee employee = modelMapper.map(employeeDTO, Employee.class);
			return repository.save(employee);
		} else {
			return null;
		}
	}
	
	@Override
	public Employee load(Long id) {
		Employee employee = repository.findOne(id);
		return employee;
	}
	
	private boolean isExist(EmployeeDTO employeeDTO) {
		Integer employeeNumbers = repository.countEmployeeByEmail(employeeDTO.getEmail());
		if (employeeNumbers > 0) {
			return true;
		} else {
			return false;
		}
	}

}
