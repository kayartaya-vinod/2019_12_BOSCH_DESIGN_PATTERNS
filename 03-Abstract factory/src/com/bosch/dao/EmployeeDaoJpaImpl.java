package com.bosch.dao;

public class EmployeeDaoJpaImpl implements EmployeeDao {

	@Override
	public void saveEmployee() {
		System.out.println("Saving employee using JPA...");
	}

}
