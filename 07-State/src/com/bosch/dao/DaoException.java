package com.bosch.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	// this is the constructor that allows an exception of one type
	// to be decorated as an exception of DaoException type
	public DaoException(Exception cause) {
		super(cause);
	}

	
	
}
