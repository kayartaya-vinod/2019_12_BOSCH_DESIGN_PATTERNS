package com.bosch.dao;

public class ProductDaoJpaImpl implements ProductDao {

	@Override
	public void saveProduct() {
		System.out.println("Saving product using JPA...");
	}

}
