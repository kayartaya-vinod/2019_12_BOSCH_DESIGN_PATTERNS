package com.bosch.programs;

import com.bosch.service.EmployeeService;

public class TestEmployeeService {

	public static void main(String[] args) {

		// class is public; no problem in creating a reference variable.
		EmployeeService es;
		// not allowed; since constructor is private (not visible)
		// es = new EmployeeService();

		// for a singleton object, always use a virtual constructor
		es = EmployeeService.getInstance();
		System.out.println("es is " + es);

		EmployeeService es1 = EmployeeService.getInstance();
		System.out.println("es1 is " + es1);

		System.out.println("es1==es is " + (es1 == es));
	}

}
