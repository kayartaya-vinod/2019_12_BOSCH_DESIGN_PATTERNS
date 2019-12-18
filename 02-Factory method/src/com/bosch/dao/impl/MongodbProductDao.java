package com.bosch.dao.impl;

import com.bosch.dao.ProductDao;

public class MongodbProductDao implements ProductDao {

	@Override
	public void saveProduct() {
		System.out.println("Saving product using Mongodb...");
	}

	@Override
	public void deleteProduct(int id) {
		System.out.println("Deleting product using Mongodb...");
	}

}
