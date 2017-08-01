package com.simon.erp.system.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.simon.erp.system.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query("SELECT COUNT(t0) FROM Employee t0 WHERE t0.email=?1")
	public Integer countEmployeeByEmail(String email);
	
}
