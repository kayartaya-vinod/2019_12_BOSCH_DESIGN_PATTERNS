package com.bosch.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bosch.service.EmployeeService;

// http://localhost:8080/mvc-demo/delete-employee?id=2
@WebServlet("/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			new EmployeeService().deleteEmployee(id);
			// req.getRequestDispatcher("/display-emps.jsp").forward(req, resp);
			resp.sendRedirect("./all-employees");
		}catch(Exception ex) {
			throw new ServletException(ex);
		}
	}
}
