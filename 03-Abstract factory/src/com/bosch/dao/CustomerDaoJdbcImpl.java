package com.bosch.dao;

public class CustomerDaoJdbcImpl implements CustomerDao {

	@Override
	public void saveCustomer() {
		System.out.println("Saving customer using JDBC...");
	}

}
