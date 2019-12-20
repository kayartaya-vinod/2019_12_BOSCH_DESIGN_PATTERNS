package com.bosch.dao;

import java.util.ResourceBundle;

public abstract class DaoFactory {
	
	static class Holder {
		private static DaoFactory instance = null; 
		static {
			
			ResourceBundle rb = ResourceBundle.getBundle("application");
			String factoryImplClass = rb.getString("dao.factory.impl");
			// for example, factoryImplClass = "com.bosch.dao.JdbcDaoFactory"
			try {
				instance = (DaoFactory) Class.forName(factoryImplClass).newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static DaoFactory getInstance() {
		return Holder.instance;
	}


	public abstract EmployeeDao getEmployeeDao();
}
