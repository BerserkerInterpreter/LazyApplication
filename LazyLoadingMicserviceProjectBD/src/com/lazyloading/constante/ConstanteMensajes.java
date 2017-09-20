package com.lazyloading.constante;

public enum ConstanteMensajes {

	DATOS_EJECUCION_NULL("com.lazyloading.mensajes.excepcion.datosejecucionnull");
	
	private String key;
	
	private ConstanteMensajes(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
