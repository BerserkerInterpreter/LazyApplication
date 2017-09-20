package com.lazyloading.db.factoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.lazyloading.db.conexion.UtilidadConexionBD;
import com.lazyloading.db.constante.ConstanteMySQLBD;
import com.lazyloading.dto.ConexionDTO;
import com.lazyloading.excepcion.ExcepcionFactoriaConexionesBD;
import com.lazyloading.factoria.FactoriaLocale;
import com.lazyloading.mensaje.UtilidadMensajes;

public class FactoriaConexionesBD {

	private Set<ConexionDTO> listaConexionesMySQL;
	
	private static FactoriaConexionesBD factoriaConexionesDB;
	
	private FactoriaConexionesBD() {
		listaConexionesMySQL = new TreeSet<ConexionDTO>();
	}
	
	public static FactoriaConexionesBD getFactoriaConexionesBD() {
		if(factoriaConexionesDB == null) {
			factoriaConexionesDB = new FactoriaConexionesBD();
		}
		return factoriaConexionesDB;
	}
	
	public ConexionDTO obtenerConexionMySQL() throws ExcepcionFactoriaConexionesBD {
		ConexionDTO conexionDTODisponible = null;
		this.validarListaConexiones();
		for(ConexionDTO conexionDTO : listaConexionesMySQL) {
			if(conexionDTO.isDisponible()) {
				conexionDTODisponible = conexionDTO;
			}
		}
		this.validarConexionDTODisponible(conexionDTODisponible);
		conexionDTODisponible.setDisponible(false);
		return conexionDTODisponible;
	}
	
	public void cerrarConexion(ConexionDTO conexionDTO) {
		this.validarConexionDTO(conexionDTO);
		conexionDTO.setDisponible(true);
	}
	
	private void validarListaConexiones() {
		if(listaConexionesMySQL.isEmpty()) {
			try {
				this.crearConexionMySQL();
			} catch (SQLException ex) {
				String key = "com.lazyloading.mensajes.excepcion.validarlistaconexiones";
				String mensaje = UtilidadMensajes.buscarMensaje(key);
				throw new ExcepcionFactoriaConexionesBD(mensaje, ex);
			}
		}
	}
	
	private void crearConexionMySQL() throws SQLException {
		String url = ConstanteMySQLBD.getURLCompleta();
		String usuario = ConstanteMySQLBD.MYSQL_USER.getValor();
		String clave = ConstanteMySQLBD.MYSQL_PASSWORD.getValor();
		Connection conexionBD = UtilidadConexionBD.obtenerConexion(url, usuario, clave);
		ConexionDTO conexionDTO = this.crearConexionDTO(conexionBD);
		this.listaConexionesMySQL.add(conexionDTO);
	}
	
	private ConexionDTO crearConexionDTO(Connection conexionJDBC) {
		ConexionDTO conexionDTO = new ConexionDTO();
		conexionDTO.setConexionBD(conexionJDBC);
		conexionDTO.setDisponible(true);
		return conexionDTO;
	}
	
	private void validarConexionDTODisponible(ConexionDTO conexionDTO) 
			throws ExcepcionFactoriaConexionesBD {
		if(conexionDTO == null) {
			String key = "com.lazyloading.mensajes.excepcion.obtenerconexionmysqlnull";
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String mensaje = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionFactoriaConexionesBD(mensaje);
		} 
	}
	
	private void validarConexionDTO(ConexionDTO conexionDTO) 
			throws ExcepcionFactoriaConexionesBD {
		if(conexionDTO == null) {
			String key = "com.lazyloading.mensajes.excepcion.cerrarconexionnull";
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String mensaje = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionFactoriaConexionesBD(mensaje);
		}
	}
	
}
