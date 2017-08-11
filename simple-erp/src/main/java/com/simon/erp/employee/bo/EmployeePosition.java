package com.simon.erp.employee.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.simon.erp.employee.bo.enumeration.PositionTypeEnum;

@Table(name="EmployeePosition")
@Entity
public class EmployeePosition {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private PositionTypeEnum type;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PositionTypeEnum getType() {
		return type;
	}

	public void setType(PositionTypeEnum type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
