package com.lazyloading.constante;

public enum ConstanteMensajes {

	OBTENER_INTEGER("com.lazyloading.mensajes.excepcion.obtenerinteger"),
	VERIFICAR_DIAS_ELEMENTOS("com.lazyloading.mensajes.excepcion.verificarDiasElementos"),
	VERIFICAR_ARRAY_DIAS_ELEMENTOS("com.lazyloading.mensajes.excepcion.verificarArrayDiasElementos"),
	VERIFICAR_VECES_UNO("com.lazyloading.mensajes.excepcion.verificarVecesUno"),
	VERIFICAR_VECES_DOS("com.lazyloading.mensajes.excepcion.verificarVecesDos"),
	VERIFICAR_CONTADOR_ARR_DIAS_ELEMENTOS("com.lazyloading.mensajes.excepcion.verificarContadorArrDiasElementos"),
	VERIFICAR_LISTA_ELEMENTOS_NULL("com.lazyloading.mensajes.excepcion.verificarListaElementosNull"),
	VERIFICAR_LISTA_ELEMENTOS_VACIA("com.lazyloading.mensajes.excepcion.verificarListaVacia"),
	VERIFICAR_ATRAS_LISTA_ELEMENTOS("com.lazyloading.mensajes.excepcion.verificarAtrasListaElementos"),
	OBTENER_LINEA_IMPRESION("com.lazyloading.mensajes.excepcion.lineaimpresion"),
	LISTA_JSON_NULL("com.lazyloading.mensajes.excepcion.listajsonnull"),
	CLASE_ELEMENTO_JSON_NULL("com.lazyloading.mensajes.excepcion.claseelementojsonnull"),
	ADAPTADOR_JSON_NULL("com.lazyloading.mensajes.excepcion.adaptadorjsonnull");
	
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
