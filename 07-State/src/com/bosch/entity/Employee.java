package com.bosch.entity;

import com.bosch.dao.EntityState;
import com.bosch.dao.Persistable;

public class Employee implements Persistable {

	private EntityState state;

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private Double salary;

	public Employee() {
	}

	public Employee(String firstname, String lastname, String email, Double salary) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String getInsertSql() {
		return "insert into employees(firstname, lastname, email, salary) values(?,?,?,?)";
	}

	@Override
	public Object[] getInsertValues() {
		return new Object[] { firstname, lastname, email, salary };
	}

	@Override
	public void changeState(EntityState state) {
		if (this.state == null || state == null) {
			this.state = state;
		}
	}

	@Override
	public EntityState getState() {
		return state;
	}

	@Override
	public String getUpdateSql() {
		return "update employees set firstname=?, lastname=?, email=?, salary=? where id=?";
	}

	@Override
	public Object[] getUpdateValues() {
		return new Object[] { firstname, lastname, email, salary, id };
	}

	@Override
	public String getDeleteSql() {
		return "delete from employees where id=?";
	}

	@Override
	public Object[] getDeleteValues() {
		return new Object[] { id };
	}

}
