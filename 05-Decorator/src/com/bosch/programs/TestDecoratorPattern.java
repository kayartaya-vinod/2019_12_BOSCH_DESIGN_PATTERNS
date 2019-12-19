package com.bosch.programs;

import com.bosch.dao.DaoException;
import com.bosch.dao.EntityManager;
import com.bosch.entity.Employee;
import com.bosch.entity.Product;

public class TestDecoratorPattern {

	public static void main(String[] args) {
		Product p1 = new Product("iPad", "electronics", 350.0);
		Employee e1 = new Employee("Shyam", "Sundar", "shyam@xmpl.com", 2700.0);
		
		// We are now decorating "p1" with additional behaviour using EntityManager
		EntityManager em1 = new EntityManager(p1);
		EntityManager em2 = new EntityManager(e1);
		
		try {
			em1.insert();
			em2.insert();
			
			System.out.println("Data saved!");
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}
