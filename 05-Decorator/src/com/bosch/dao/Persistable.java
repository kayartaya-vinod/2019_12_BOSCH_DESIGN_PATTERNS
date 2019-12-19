package com.bosch.dao;

public interface Persistable {
	
	public String getInsertSql();

	public Object[] getInsertValues();
	
	// more methods for update/delete/select etc, later
}
