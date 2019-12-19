package com.bosch.programs;

import com.bosch.dao.ProductDao;
import com.bosch.entity.Product;

public class UpdateProductDetails {

	public static void main(String[] args) {
		
		// typically you should get a product form the DB, and make
		// necessary changes, and then update
		Product p1 = new Product("Orange", "Fruit", 9.5);
		p1.setId(3);
		
		ProductDao dao = new ProductDao();
		// dao.update(p1);
		dao.delete(p1);
		
		System.out.println("Product data updated!");
		
	}
}
