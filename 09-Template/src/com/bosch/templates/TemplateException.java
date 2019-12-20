package com.bosch.templates;

public class TemplateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TemplateException() {
	}

	public TemplateException(String message) {
		super(message);
	}

	public TemplateException(Throwable cause) {
		super(cause);
	}

	public TemplateException(String message, Throwable cause) {
		super(message, cause);
	}

	public TemplateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
