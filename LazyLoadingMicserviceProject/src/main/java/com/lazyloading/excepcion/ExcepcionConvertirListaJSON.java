package com.lazyloading.excepcion;

public class ExcepcionConvertirListaJSON extends RuntimeException {

	public ExcepcionConvertirListaJSON() {
		super();
	}

	public ExcepcionConvertirListaJSON(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcepcionConvertirListaJSON(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionConvertirListaJSON(String message) {
		super(message);
	}

	public ExcepcionConvertirListaJSON(Throwable cause) {
		super(cause);
	}

}
