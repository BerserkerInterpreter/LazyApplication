package com.lazyloading.dto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lazyloading.constante.TipoConexionBD;
import com.lazyloading.db.factoria.FactoriaConexionesBD;
import com.lazyloading.excepcion.ExcepcionConexionDTO;
import com.lazyloading.mensaje.UtilidadMensajes;

public class ConexionDTO implements Comparable<ConexionDTO>, Serializable {

	private Connection conexionBD;
	private boolean disponible;
	private TipoConexionBD tipoConexionBD;

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Connection getConexionBD() {
		return conexionBD;
	}

	public void setConexionBD(Connection conexionBD) {
		this.conexionBD = conexionBD;
	}
	
	public TipoConexionBD getTipoConexionBD() {
		return tipoConexionBD;
	}

	public void setTipoConexionBD(TipoConexionBD tipoConexionBD) {
		this.tipoConexionBD = tipoConexionBD;
	}

	public void cerrarConexion() {
		FactoriaConexionesBD factoriaConexionesDB =
				FactoriaConexionesBD.getFactoriaConexionesBD();
		factoriaConexionesDB.cerrarConexion(this);
	}
	
	public Statement obtenerStatement() throws SQLException {
		this.validarConexionBD();
		Statement statement = conexionBD.createStatement();
		return statement;
	}
	
	public PreparedStatement obtenerPreparedStatement(String sql) throws SQLException {
		this.validarConexionBD();
		PreparedStatement preparedStatement = conexionBD.prepareStatement(sql);
		return preparedStatement;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean resultado = false;
		if(object instanceof ConexionDTO) {
			ConexionDTO otraConexionDTO = (ConexionDTO) object;
			Connection otraConexionBD = otraConexionDTO.getConexionBD();
			resultado = conexionBD.equals(otraConexionBD);
		}
		return resultado;
	}
	
	@Override
	public int hashCode() throws ExcepcionConexionDTO {
		this.validarConexionBD();
		int resultado = conexionBD.hashCode() * 25 + 70;
		return resultado;
	}
	
	@Override
	public int compareTo(ConexionDTO otraConexionDTO) {
		byte resultado = 0;
		if(otraConexionDTO == null) {
			resultado = 1;
			return resultado;
		}
		Connection otraConexionBD = otraConexionDTO.getConexionBD(); 
		resultado = this.validarHashCode(otraConexionBD);
		return resultado;
	}
	
	private void validarConexionBD() throws ExcepcionConexionDTO {
		if(conexionBD == null) {
			String key = "com.lazyloading.mensajes.excepcion.conexionbdnull";
			String mensaje = UtilidadMensajes.buscarMensaje(key);
			throw new ExcepcionConexionDTO(mensaje);
		}
	}
	
	private byte validarHashCode(Connection otraConexionBD) {
		if(otraConexionBD == null) {
			return 1;
		} else if(conexionBD.hashCode() == otraConexionBD.hashCode()) {
			return 0;
		} else if(conexionBD.hashCode() > otraConexionBD.hashCode()) {
			return 1;
		} else {
			return -1;
		}
	}
}
