package com.bosch.dao;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public final class DaoFactory {

	private DaoFactory() {
	}
	
	public static ProductDao getProductDao() {
		// should return either DummyProductDao or a proxy
		// based on the value for "productDao.enable.proxy" in 
		// application.properties file
		ResourceBundle rb = ResourceBundle.getBundle("application");
		String value = rb.getString("productDao.enable.proxy");
		Boolean proxyEnabled = new Boolean(value);
		
		if(proxyEnabled) {
			return (ProductDao) Proxy.newProxyInstance(
					DaoFactory.class.getClassLoader(), // class loader
					new Class[] {ProductDao.class},    // list of interfaces
					new ProxyProductDao(new DummyProductDao()) // proxy instance
					);
		}
		else {
			return new DummyProductDao();
		}
	}
	
}
