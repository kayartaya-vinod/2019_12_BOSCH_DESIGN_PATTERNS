package com.bosch.dao;


// this is an observer interface
@FunctionalInterface
public interface DataInsertListener {
	public void onDataInserted(String event);
}
