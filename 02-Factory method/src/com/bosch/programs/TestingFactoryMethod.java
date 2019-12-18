package com.bosch.programs;

import com.bosch.dao.DaoFactory;
import com.bosch.dao.ProductDao;

public class TestingFactoryMethod {

	public static void main(String[] args) {
		ProductDao dao;
		
		// dao = new HibernateProductDao(); // tight coupling
		
		// use a virtual constructor (a factory method)
		// by supplying a discriminator, we can get a different implementation
		// every time.
		
		dao = DaoFactory.getProductDao();
		
		dao.saveProduct();
		dao.deleteProduct(2);
	}
}
