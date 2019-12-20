package com.bosch.dao;

import java.util.List;

import com.bosch.entity.Employee;

public interface EmployeeDao {
	
	// CRUD operations
	
	public void deleteEmployee(int id) throws DaoException;
	
	// QUERIES
	public List<Employee> getAllEmployees() throws DaoException;
	
}
