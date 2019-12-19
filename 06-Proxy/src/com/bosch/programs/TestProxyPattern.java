package com.bosch.programs;

import com.bosch.dao.DaoFactory;
import com.bosch.dao.ProductDao;

public class TestProxyPattern {

	public static void main(String[] args) {
		
		ProductDao dao = DaoFactory.getProductDao();
		
		System.out.println("dao is an instanceof: " + dao.getClass());
		dao.saveProduct();
		dao.deleteProduct();
		int pc = dao.getProductCount();
		System.out.println("There are " + pc + " products.");
		
	}
}
