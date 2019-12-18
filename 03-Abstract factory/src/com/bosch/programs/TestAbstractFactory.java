package com.bosch.programs;

import com.bosch.dao.CustomerDao;
import com.bosch.dao.DaoFactory;
import com.bosch.dao.EmployeeDao;
import com.bosch.dao.ProductDao;

public class TestAbstractFactory {

	public static void main(String[] args) {
		
		DaoFactory factory = DaoFactory.getInstance();
		System.out.println("factory is an instanceof " + factory.getClass());
		
		ProductDao pdao = factory.getProductDao();
		CustomerDao cdao = factory.getCustomerDao();
		EmployeeDao edao = factory.getEmployeeDao();
		
		pdao.saveProduct();
		cdao.saveCustomer();
		edao.saveEmployee();
		
				
	}
}
