package com.bosch.dao.impl;

import com.bosch.dao.ProductDao;

public class JdbcProductDao implements ProductDao {

	@Override
	public void saveProduct() {
		System.out.println("Saving product using JDBC...");
	}

	@Override
	public void deleteProduct(int id) {
		System.out.println("Deleting product using JDBC...");
	}

}
