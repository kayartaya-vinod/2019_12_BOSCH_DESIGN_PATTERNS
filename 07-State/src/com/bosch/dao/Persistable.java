package com.bosch.dao;

public interface Persistable {

	public void changeState(EntityState state);

	public EntityState getState();

	public String getInsertSql();

	public Object[] getInsertValues();

	public String getUpdateSql();

	public Object[] getUpdateValues();

	public String getDeleteSql();

	public Object[] getDeleteValues();

}
