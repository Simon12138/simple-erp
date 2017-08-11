package com.simon.erp.api.employee.ro;

import org.dozer.Mapping;

import com.simon.erp.api.employee.dto.EmployeePositionDTO;
import com.simon.erp.api.frw.AbstractResourceObject;

public class EmployeeRO extends AbstractResourceObject {
	
	private String id;
	
	private String email;
	
	private String password;
	
	@Mapping("position")
	private EmployeePositionDTO position;
	
	public EmployeeRO() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EmployeePositionDTO getPosition() {
		return position;
	}

	public void setPosition(EmployeePositionDTO position) {
		this.position = position;
	}
}
