package com.lazyloading.configuracion;

public enum ConstanteConfiguracion {
	
	CODIGO_RESULTADO_EXITO("com.lazyloading.configuracion.codigoresultadoexitoso"),
	CODIGO_RESULTADO_ERROR("com.lazyloading.configuracion.codigoresultadoerror"), 
	MENSAJE_EJECUCION_EXITO("com.lazyloading.configuracion.mensajeejecucionexito"), 
	MENSAJE_EJECUCION_ERROR("com.lazyloading.configuracion.mensajeejecucionerror"), 
	NOMBRE_RESOURCE_BUNDLE_CONFIGURACION("com.lazyloading.configuracion.configuracion");
	
	private String key;
	
	private ConstanteConfiguracion(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
  
}
