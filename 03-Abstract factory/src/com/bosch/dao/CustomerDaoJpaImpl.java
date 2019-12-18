package com.bosch.dao;

public class CustomerDaoJpaImpl implements CustomerDao {

	@Override
	public void saveCustomer() {
		System.out.println("Saving customer using JPA...");
	}

}
