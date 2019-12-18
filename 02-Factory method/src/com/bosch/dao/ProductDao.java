package com.bosch.dao;

public interface ProductDao {
	// Typically CRUD operations and queries will be written in a DAO class

	public void saveProduct(); // supposed to take a product and save it to DB.

	public void deleteProduct(int id);

}
