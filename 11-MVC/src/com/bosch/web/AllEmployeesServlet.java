package com.bosch.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bosch.entity.Employee;
import com.bosch.service.EmployeeService;
import com.bosch.service.ServiceException;

@WebServlet("/all-employees")
public class AllEmployeesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			// Responsibilities in a controller:
			// 1. read inputs from client (N/A for this demo)
			
			// 2. get model data from service/dao layer
			EmployeeService service = new EmployeeService();
			List<Employee> emps = service.getAllEmployees();
			
			// 3. store the model data in a storage (scope) accessible to view
			req.setAttribute("emps", emps);
			
			// 4. forward (delegate) to the view
			req.getRequestDispatcher("/display-emps.jsp").forward(req, resp);
		} catch (ServiceException e) {
			throw new ServletException(e);
		}
	
	}

}













