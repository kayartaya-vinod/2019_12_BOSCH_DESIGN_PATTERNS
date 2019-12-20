package com.bosch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbConnectionFactory {

	private DbConnectionFactory() {
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// src/application.properties
		ResourceBundle rb = ResourceBundle.getBundle("application"); 
		String driverClassName = rb.getString("jdbc.driverClassName");
		String url = rb.getString("jdbc.url");
		String username = rb.getString("jdbc.username");
		String password = rb.getString("jdbc.password");
		// At this time, DriverManager.registeredDrivers.size() ==0
		Class.forName(driverClassName);
		// At this time, DriverManager.registeredDrivers.size() ==1
		return DriverManager.getConnection(url, username, password);
	}
}
