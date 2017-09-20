package com.lazyloading.db.constante;

import com.lazyloading.mensaje.UtilidadMensajes;

public enum ConstanteMySQLBD {

	MYSQL_HOST_ADDRESS("com.lazyloading.db.mysql.hostaddress"),
	MYSQL_HOST_PORT("com.lazyloading.db.mysql.hostport"),
	MYSQL_HOST_DATABASE("com.lazyloading.db.mysql.hostdatabase"),
	MYSQL_USER("com.lazyloading.db.mysql.usuario"),
	MYSQL_PASSWORD("com.lazyloading.db.mysql.password"),
	MYSQL_URL_FORMAT("com.lazyloading.db.mysql.urlformat");
	
	private String valor;
	
	private ConstanteMySQLBD(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public static String getURLCompleta() {
		String urlFormat = UtilidadMensajes.buscarMensaje(MYSQL_URL_FORMAT.getValor());
		String urlCompleta = 
			String.format(urlFormat, MYSQL_HOST_ADDRESS.getValor(),
						MYSQL_HOST_PORT.getValor(),
						MYSQL_HOST_DATABASE.getValor());
		return urlCompleta;
	}
  
}
