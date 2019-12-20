package com.bosch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bosch.util.DbConnectionFactory;

// This is a subject (in observer pattern), which maintiains
// a collection of observers. This should provide the following operations:
// 1. register new observer
// 2. unregister an existing observer
// 3. notifying all registered observers on an event
public abstract class AbstractDao<T> {

	// list of registered DataInserListeners
	private List<DataInsertListener> insertListeners = new ArrayList<DataInsertListener>();
	
	public void addDataInsertListener(DataInsertListener listener) {
		insertListeners.add(listener);
	}
	
	public void notifyInsertListeners(String event) {
		for(DataInsertListener l: insertListeners) {
			l.onDataInserted(event);
		}
	}
	
	private void executeSql(String sqlCmd, Object[] values) {
				
		try(
			Connection conn = DbConnectionFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlCmd);
		) {
			for (int i = 0; i < values.length; i++) {
				stmt.setObject(i+1, values[i]);
			}
			stmt.executeUpdate();
		}
		catch(Exception ex) {
			// exception ducking; should never be done.
			ex.printStackTrace();
		}
	}

	public void insert(T entity) {
		String sqlCmd = getInsertSql();
		Object[] values = getInsertValues(entity);
		executeSql(sqlCmd, values);
		notifyInsertListeners("SQL: " + sqlCmd + ", Values: " + Arrays.toString(values));
	}
	
	public void update(T entity) {
		String sqlCmd = getUpdateSql();
		Object[] values = getUpdateValues(entity);
		executeSql(sqlCmd, values);
	}
	
	public void delete(T entity) {
		String sqlCmd = getDeleteSql();
		Object[] values = getDeleteValues(entity);
		executeSql(sqlCmd, values);
	}
	
	// missing algorithm (strategy), will be provided by subclass
	protected abstract String getInsertSql();
	protected abstract Object[] getInsertValues(T entity);
	protected abstract String getUpdateSql();
	protected abstract Object[] getUpdateValues(T entity);
	protected abstract String getDeleteSql();
	protected abstract Object[] getDeleteValues(T entity);
	
	
}








