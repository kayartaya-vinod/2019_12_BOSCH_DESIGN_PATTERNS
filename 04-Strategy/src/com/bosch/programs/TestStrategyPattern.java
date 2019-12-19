package com.bosch.programs;

import com.bosch.dao.EmployeeDao;
import com.bosch.dao.ProductDao;
import com.bosch.entity.Employee;
import com.bosch.entity.Product;

public class TestStrategyPattern {

	public static void main(String[] args) {
		Employee e1 = new Employee("John", "Doe", "johndoe@xmpl.com", 2500.0);
		Employee e2 = new Employee("Robert", "Martin", "robert.martin@xmpl.com", 2200.0);
		
		Product p1 = new Product("Orange", "fruit", 7.0);
		
		EmployeeDao edao = new EmployeeDao();
		ProductDao pdao = new ProductDao();
		
		edao.insert(e1);
		edao.insert(e2);
		
		pdao.insert(p1);
		
		System.out.println("Data inserted!");
	}
}
