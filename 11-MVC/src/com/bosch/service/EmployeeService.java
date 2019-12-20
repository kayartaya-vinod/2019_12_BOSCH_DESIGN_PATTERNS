package com.bosch.service;

import java.util.List;

import com.bosch.dao.DaoException;
import com.bosch.dao.DaoFactory;
import com.bosch.dao.EmployeeDao;
import com.bosch.entity.Employee;

public class EmployeeService {

	EmployeeDao dao = DaoFactory.getInstance().getEmployeeDao();
	
	// @AllowedRoles({"admin", "superuser"})
	public List<Employee> getAllEmployees() throws ServiceException {
		try {
			return dao.getAllEmployees();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	public void deleteEmployee(int id) throws ServiceException {
		try {
			dao.deleteEmployee(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
