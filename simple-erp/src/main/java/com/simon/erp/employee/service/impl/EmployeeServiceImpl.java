package com.simon.erp.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.simon.erp.bo.frw.BusinessObject;
import com.simon.erp.bo.frw.service.BusinessObjectService;
import com.simon.erp.employee.bo.Employee;
import com.simon.erp.employee.repository.EmployeeRepository;
import com.simon.erp.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService, BusinessObjectService<BusinessObject> {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Long register(Employee employee) {
		if (!isExist(employee)) {
			Employee newEmployee = repository.save(employee);
			return newEmployee.getId();
		} else {
			return null;
		}
	}
	
	@Override
	public boolean login(Employee employee) {
		String loginName = null;
		if(!StringUtils.isEmpty(employee.getEmail())) {
			loginName = employee.getEmail();
		}
		if(loginName == null) {
			return false;
		} else {
			String sql = String.format("SELECT count(*) FROM Employees t0 WHERE t0.email=:email AND t0.password=:password");
			Query query = em.createNativeQuery(sql);
			query.setParameter("email", employee.getEmail());
			query.setParameter("password", employee.getPassword());
			Integer result = Integer.parseInt(query.getSingleResult().toString());
			if(result > 0) {
				return true;
			} else {
				return false;
			}
		}
	}	
	
	@Override
	public Employee load(Long id) {
		Employee employee = repository.findOne(id);
		return employee;
	}
	
	private boolean isExist(Employee employee) {
		Integer employeeNumbers = repository.countEmployeeByEmail(employee.getEmail());
		if (employeeNumbers > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> list() {
		ArrayList<Employee> employees = new ArrayList<>();
		repository.findAll().forEach(item -> employees.add(item));
		return employees;
	}

}
