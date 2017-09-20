package com.lazyloading.db.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class UtilidadConexionBD {

	public static Connection obtenerConexion(String url, Properties properties) 
			throws SQLException {
		validarParametros(url, properties);
		Connection conexionBD = 
				DriverManager.getConnection(url, properties);
		return conexionBD;
	}
	
	public static Connection obtenerConexion(String url, String user, String password) 
			throws SQLException {
		validarParametros(url, user, password);
		Connection conexionBD = 
				DriverManager.getConnection(url, user, password);
		return conexionBD;
	}
	
	private static void validarParametros(String url, Properties properties) {
		// TODO Auto-generated method stub
	}
	
	private static void validarParametros(String url, String user, String password) {
		// TODO Auto-generated method stub
	}
	  
}
