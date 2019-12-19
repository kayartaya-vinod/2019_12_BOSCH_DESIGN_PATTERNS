package com.bosch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.bosch.util.DbConnectionFactory;

public class EntityManager {

	private List<Persistable> cache = new ArrayList<Persistable>();

	public void insert(Persistable entity) {
		entity.changeState(EntityState.NEW);
		cache.add(entity);
	}

	public void update(Persistable entity) {
		entity.changeState(EntityState.DIRTY);
		cache.add(entity);
	}

	public void delete(Persistable entity) {
		entity.changeState(EntityState.REMOVED);
		cache.add(entity);
	}

	// application of STATE design pattern
	public void commit() throws DaoException {
		for (Persistable p : cache) {
			if (p.getState() == EntityState.NEW) {
				String sqlCmd = p.getInsertSql();
				Object[] values = p.getInsertValues();
				executeSql(sqlCmd, values);
			} else if (p.getState() == EntityState.DIRTY) {
				String sqlCmd = p.getUpdateSql();
				Object[] values = p.getUpdateValues();
				executeSql(sqlCmd, values);
			} else if (p.getState() == EntityState.REMOVED) {
				String sqlCmd = p.getDeleteSql();
				Object[] values = p.getDeleteValues();
				executeSql(sqlCmd, values);
			}
			p.changeState(null);
		}
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

}
