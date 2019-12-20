package com.bosch.dao;

public class JdbcDaoFactory extends DaoFactory {


	@Override
	public EmployeeDao getEmployeeDao() {
		return new JdbcEmployeeDao();
	}

}
