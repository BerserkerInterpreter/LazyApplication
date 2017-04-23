package com.lazyloading.excepciones;

public class ExcepcionDias extends Exception {

	public ExcepcionDias() {
		super();
	}

	public ExcepcionDias(String message) {
		super(message);
	}

	public ExcepcionDias(Throwable cause) {
		super(cause);
	}

	public ExcepcionDias(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionDias(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
