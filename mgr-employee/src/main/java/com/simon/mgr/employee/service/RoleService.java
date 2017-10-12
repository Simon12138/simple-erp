package com.simon.mgr.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simon.mgr.employee.bo.Role;

@Service
public interface RoleService {
	
	public Role createRole(Role role);
	
	public Role updateRole(Role role);
	
	public void deleteRole(Long id);
	
	public List<Role> fetchAllRoles();
	
	public Role fetchOne(Long id);
	
	public void attachRule(Long roleId, Long ruleId);
	
	public void detachRule(Long roleId, Long ruleId);
}
