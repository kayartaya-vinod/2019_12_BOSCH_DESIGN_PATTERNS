package com.bosch.dao;

import com.bosch.entity.Employee;

public class EmployeeDao extends AbstractDao<Employee> {

	@Override
	protected String getInsertSql() {
		return "insert into employees (firstname, lastname, email, salary) values (?,?,?,?)";
	}

	@Override
	protected Object[] getInsertValues(Employee e) {
		return new Object[] { 
				e.getFirstname(), e.getLastname(), 
				e.getEmail(), e.getSalary() };
	}

	@Override
	protected String getUpdateSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getUpdateValues(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object[] getDeleteValues(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
