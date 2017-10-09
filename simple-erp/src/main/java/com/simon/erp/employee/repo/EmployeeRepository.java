package com.simon.erp.employee.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simon.erp.employee.bo.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
