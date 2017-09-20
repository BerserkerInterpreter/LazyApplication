package com.lazyloading.constante;

public enum ConstanteMensajes {

	DATOS_EJECUCION_NULL("com.lazyloading.mensajes.excepcion.datosejecucionnull"),
	ERROR_INSERTAR_EJECUCION("com.lazyloading.mensajes.excepcion.errorinsertarejecucion"), 
	ERROR_INSERTAR_LINEAS_IMPRESION("com.lazyloading.mensajes.excepcion.errorinsertarlineasimpresion"), 
	ERROR_ADICIONAR_EJECUCION("com.lazyloading.mensajes.excepcion.erroradicionarejecucion"), 
	ERROR_INICIALIZAR_CONTEXTO("com.lazyloading.mensajes.excepcion.errorinicializarcontexto"), 
	ERROR_NUMERO_IDENTIFACION_EJECUCION("com.lazyloading.mensajes.excepcion.errornumeroidentificacionejecucion"), 
	ERROR_VALIDAR_FECHA_EJECUCION("com.lazyloading.mensajes.excepcion.errorvalidarfechaejecucion"), 
	ERROR_VALIDAR_LINEAS_IMPRESION("com.lazyloading.mensajes.excepcion.errorvalidarlineasimpresion"), 
	ERROR_PROCESAR_FECHA("com.lazyloading.mensajes.excepcion.errorprocesarfecha"), 
	ERROR_ROLLBACK_CONEXION_BD("com.lazyloading.mensajes.excepcion.errorrollbackconexionbd"), 
	DATOS_EJECUCION_VACIO("com.lazyloading.mensajes.excepcion.datosejecucionvacio");
	
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
