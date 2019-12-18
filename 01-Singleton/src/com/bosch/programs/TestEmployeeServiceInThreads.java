package com.bosch.programs;

import com.bosch.service.EmployeeService;

public class TestEmployeeServiceInThreads {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			Runnable runnable = () -> {
				EmployeeService es = EmployeeService.getInstance();
				System.out.println(es);
			};
			
			new Thread(runnable).start();
		}

	}
}
