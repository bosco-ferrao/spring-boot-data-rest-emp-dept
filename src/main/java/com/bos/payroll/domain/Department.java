package com.bos.payroll.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Bosco Ferrao
 */
// tag::code[]
@Entity
public class Department {

	private @Id @GeneratedValue Long id;
	private String name;
	@OneToMany
	private Collection <Employee> employees = new ArrayList<Employee>();
	
	public Department() {
		
	}
	public Department(String name) {
		this.name = name;
	}

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
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
}
// end::code[]