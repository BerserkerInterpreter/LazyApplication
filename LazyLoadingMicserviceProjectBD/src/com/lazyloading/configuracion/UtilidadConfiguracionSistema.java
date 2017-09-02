package com.lazyloading.configuracion;

import java.util.ResourceBundle;

public final class UtilidadConfiguracionSistema {
	
	private static final String RES_BUNDLE_CONFIGURACION = "com.lazyloading.configuracion.configuracion";
	private static final String LENGUAJE = "com.lazyloading.configuracion.locale.lenguaje";
	private static final String PAIS = "com.lazyloading.configuracion.locale.pais";
	private static final String RES_BUNDLE_MENSAJES_BASE_NAME = "com.lazyloading.configuracion.locale.resbundlemensajesbasename";
	
	private static final String SEPARADOR = "com.lazyloading.configuracion.tokenizacion.separador";
	private static final String REEMPLAZO = "com.lazyloading.configuracion.tokenizacion.reemplazo";
	private static final String UNIDAD_PESO = "com.lazyloading.configuracion.peso.unidadpeso";
	private static final String LOGGIN_PATH = "com.lazyloading.configuracion.logs.loggingpath";
	private static final String LOGGING_SYSTEM_PROPERTY = "com.lazyloading.configuracion.logs.logginsysproperty";
	
	private UtilidadConfiguracionSistema() { 
		super();
	}
	
	public static String getResBundleMensajesBaseName() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String mensajesBaseName = resourceBundle.getString(RES_BUNDLE_MENSAJES_BASE_NAME);
		return mensajesBaseName;
	}
	
	public static String getLenguaje() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String lenguaje = resourceBundle.getString(LENGUAJE);
		return lenguaje;
	}
	
	public static String getPais() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String pais = resourceBundle.getString(PAIS);
		return pais;
	}
	
	public static String getSeparador() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String separador = resourceBundle.getString(SEPARADOR);
		return separador;
	}
	
	public static String getReemplazo() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String reemplazo = resourceBundle.getString(REEMPLAZO);
		return reemplazo;
	}
	
	public static String getUnidadPeso() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String unidadPeso = resourceBundle.getString(UNIDAD_PESO);
		return unidadPeso;
	}
	
	public static String getLoggingPath() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String loggingPath = resourceBundle.getString(LOGGIN_PATH);
		return loggingPath;
	}
	
	public static String getLoggingSystemProperty() {
		ResourceBundle resourceBundle = 
				ResourceBundle.getBundle(RES_BUNDLE_CONFIGURACION);
		String loggingSystemProperty = resourceBundle.getString(LOGGING_SYSTEM_PROPERTY);
		return loggingSystemProperty;
	}
	
}
