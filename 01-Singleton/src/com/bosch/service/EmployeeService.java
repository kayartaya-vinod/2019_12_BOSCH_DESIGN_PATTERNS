package com.bosch.service;

public class EmployeeService {

	private static EmployeeService instance = new EmployeeService();

	// user should not be allowed to create objects using "new" keyword
	private EmployeeService() {
		System.out.println();
	}

	public static EmployeeService getInstance() {
//		if (instance == null) {
//			// lazy initialization
//			instance = new EmployeeService();
//		}
		return instance;
	}

	// other EmployeeService methods
}
