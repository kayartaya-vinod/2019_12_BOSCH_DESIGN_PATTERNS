package com.bosch.dao.impl;

import com.bosch.dao.ProductDao;

public class HibernateProductDao implements ProductDao {

	@Override
	public void saveProduct() {
		System.out.println("Saving product using Hibernate...");
	}

	@Override
	public void deleteProduct(int id) {
		System.out.println("Deleting product using Hibernate...");
	}

}
