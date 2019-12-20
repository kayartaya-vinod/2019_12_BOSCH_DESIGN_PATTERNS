package com.bosch.programs;

import java.util.Date;

import com.bosch.dao.DataInsertListener;
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

		// register a listener for insert event on EmployeeDao
		edao.addDataInsertListener(System.out::println);
		edao.addDataInsertListener(new DataInsertListener() {
			@Override
			public void onDataInserted(String event) {
				System.out.println("Some data inserted at: " + new Date().toString());
			}
		});

		edao.insert(e1);
		edao.insert(e2);

		pdao.insert(p1);

		System.out.println("Data inserted!");
	}
}
