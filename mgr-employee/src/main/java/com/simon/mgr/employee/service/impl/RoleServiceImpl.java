package com.simon.mgr.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.simon.mgr.employee.bo.AuthorizationRule;
import com.simon.mgr.employee.bo.Role;
import com.simon.mgr.employee.repo.AuthorizationRuleRepository;
import com.simon.mgr.employee.repo.RoleRepository;
import com.simon.mgr.employee.service.RoleService;

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private AuthorizationRuleRepository ruleRepo;

	@Override
	public Role createRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public void deleteRole(Long id) {
		roleRepo.delete(id);
	}

	@Override
	public List<Role> fetchAllRoles() {
		ArrayList<Role> roles = new ArrayList<>();
		roleRepo.findAll().forEach(item -> roles.add((Role) item));
		return roles;
	}

	@Override
	public Role fetchOne(Long id) {
		return roleRepo.findOne(id);
	}

	@Override
	public void attachRule(Long roleId, Long ruleId) {
		Role role = roleRepo.findOne(roleId);
		AuthorizationRule rule = ruleRepo.findOne(ruleId);
		role.addRule(rule);
		roleRepo.save(role);
	}

	@Override
	public void detachRule(Long roleId, Long ruleId) {
		Role role = roleRepo.findOne(roleId);
		AuthorizationRule rule = ruleRepo.findOne(ruleId);
		role.removeRule(rule);
		roleRepo.save(role);
	}

}
