package com.simon.erp.rest.ro;

import com.simon.erp.rest.frw.AbstractResourceObject;

public class EmployeeRO extends AbstractResourceObject {
	
	private String id;
	
	private String email;
	
	private String password;

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
	
}
