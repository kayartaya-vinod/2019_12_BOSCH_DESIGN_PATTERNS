package com.bosch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bosch.util.DbConnectionFactory;

// This is a generic class, that defines methods for 
// inserting, updating, deleting, and fetching the data from the DB.
// And this class is not bound to any specific entities.
public abstract class AbstractDao<T> {

	private void executeSql(String sqlCmd, Object[] values) {
		// 1. open a DB connection
		// 2. create an SQL insert command (String) with parameters
		// 3. create an array of values for the SQL parameters
		// 4. create a PreparedStatement using the above sql command
		// 5. set all the parameters of the PreparedStatement
		// 6. execute the SQL command of the PreparedStatement
		// 7. handle exceptions, by re-throwing the same
				
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








