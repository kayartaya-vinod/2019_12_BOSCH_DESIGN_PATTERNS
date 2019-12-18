package com.bosch.dao;

import java.util.ResourceBundle;

import com.bosch.dao.impl.HibernateProductDao;
import com.bosch.dao.impl.JdbcProductDao;
import com.bosch.dao.impl.MongodbProductDao;

// we do not want an object of this class at all.
// we can achieve this by making the class as final and constructor as private
public final class DaoFactory {

	private DaoFactory() {
	}
	
	public static ProductDao getProductDao() {
		String discriminiator = System.getenv().get("product_dao_impl");
//		ResourceBundle rb = ResourceBundle.getBundle("application");
//		String discriminiator = rb.getString("productDao.impl");
		return getProductDao(discriminiator);
	}

	public static ProductDao getProductDao(String discriminator) {

		switch (discriminator.toLowerCase()) {
		case "jdbc":
			return new JdbcProductDao();
		case "hibernate":
			return new HibernateProductDao();
		case "mongodb":
			return new MongodbProductDao();
		default:
			throw new RuntimeException("Invalid discriminator: " + discriminator);
		}
	}

}
