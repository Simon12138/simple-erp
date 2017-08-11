package com.simon.erp.employee.dto;

import com.simon.erp.api.frw.DataTransferObject;

public class EmployeePositionDTO extends DataTransferObject {
	
	private Long id;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
