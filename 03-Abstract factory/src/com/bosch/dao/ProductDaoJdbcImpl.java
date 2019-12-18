package com.bosch.dao;

public class ProductDaoJdbcImpl implements ProductDao {

	@Override
	public void saveProduct() {
		System.out.println("Saving product using JDBC...");
	}

}
