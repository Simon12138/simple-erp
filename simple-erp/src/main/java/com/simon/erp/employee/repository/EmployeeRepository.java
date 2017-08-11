package com.simon.erp.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simon.erp.employee.bo.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query("SELECT COUNT(t0) FROM Employee t0 WHERE t0.email=?1")
	public Integer countEmployeeByEmail(String email);
	
}
