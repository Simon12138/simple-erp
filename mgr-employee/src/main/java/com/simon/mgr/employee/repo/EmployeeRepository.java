package com.simon.mgr.employee.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simon.mgr.employee.bo.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
