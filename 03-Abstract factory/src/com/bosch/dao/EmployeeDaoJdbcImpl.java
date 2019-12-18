package com.bosch.dao;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void saveEmployee() {
		System.out.println("Saving employee using JDBC...");
	}

}
