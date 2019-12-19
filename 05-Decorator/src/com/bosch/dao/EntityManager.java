package com.bosch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bosch.util.DbConnectionFactory;

public class EntityManager {

	private Persistable entity;

	// only one constructor that takes Persistable as argument
	public EntityManager(Persistable entity) {
		this.entity = entity;
	}

	private void executeSql(String sqlCmd, Object[] values) throws DaoException {
		try (Connection conn = DbConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlCmd);) {
			for (int i = 0; i < values.length; i++) {
				stmt.setObject(i + 1, values[i]);
			}
			stmt.executeUpdate();
		} catch (Exception ex) {
			// exception funnelling (using decorator pattern)
			throw new DaoException(ex);
		}
	}

	// high level functions that make use of low level
	// functions provided by the contained object, with
	// 'strategy' or 'algorithm'
	public void insert() throws DaoException {
		String sqlCmd = this.entity.getInsertSql();
		Object[] values = this.entity.getInsertValues();
		this.executeSql(sqlCmd, values);
	}

	public void update() {
	}

	public void delete() {
	}

}
