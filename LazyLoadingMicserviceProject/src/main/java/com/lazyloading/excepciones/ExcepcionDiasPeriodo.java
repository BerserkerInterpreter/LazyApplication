package com.lazyloading.excepciones;

public class ExcepcionDiasPeriodo extends Exception {

	public ExcepcionDiasPeriodo() {
		super();
	}

	public ExcepcionDiasPeriodo(String message) {
		super(message);
	}

	public ExcepcionDiasPeriodo(Throwable cause) {
		super(cause);
	}

	public ExcepcionDiasPeriodo(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionDiasPeriodo(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
