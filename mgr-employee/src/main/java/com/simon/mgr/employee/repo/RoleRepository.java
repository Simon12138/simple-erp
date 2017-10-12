package com.simon.mgr.employee.repo;

import org.springframework.data.repository.CrudRepository;

import com.simon.mgr.employee.bo.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
