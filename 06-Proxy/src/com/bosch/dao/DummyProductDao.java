package com.bosch.dao;

public class DummyProductDao implements ProductDao {

	@Override
	public void saveProduct() {
		System.out.println("Saving product...");
	}

	@Override
	public void deleteProduct() {
		System.out.println("Deleting product...");
	}

	@Override
	public int getProductCount() {
		System.out.println("Getting product count...");
		return 77;
	}

}
