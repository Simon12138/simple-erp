package com.simon.mgr.employee.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Role_Rule", 
		joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "rule_id", referencedColumnName = "id"))
	private Set<AuthorizationRule> rules = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<AuthorizationRule> getRules() {
		return rules;
	}

	public void setRules(Set<AuthorizationRule> rules) {
		this.rules = rules;
	}
	
	public void addRule(AuthorizationRule rule) {
		rules.add(rule);
	}
	
	public void removeRule(AuthorizationRule rule) {
		rules.remove(rule);
	}
}
