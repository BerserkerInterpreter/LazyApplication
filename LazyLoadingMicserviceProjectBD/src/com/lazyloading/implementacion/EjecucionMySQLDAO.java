package com.lazyloading.dao.implementacion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.lazyloading.dao.interfaz.EjecucionDAO;
import com.lazyloading.db.factoria.FactoriaConexionesBD;
import com.lazyloading.dto.ConexionDTO;
import com.lazyloading.dto.EjecucionDTO;

public class EjecucionMySQLDAO implements EjecucionDAO {

	@Override
	public void adicionarEjecucion(EjecucionDTO ejecucionDTO) {
		FactoriaConexionesBD factoriaConexionesBD = FactoriaConexionesBD.getFactoriaConexionesBD();
		ConexionDTO conexionDTO = factoriaConexionesBD.obtenerConexionMySQL();
		String insercionSQL = "";
		try {
			PreparedStatement preparedStatement = conexionDTO.obtenerPreparedStatement(insercionSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public EjecucionDTO buscarEjecucion(String codigoEjecucion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarEjecucion(EjecucionDTO ejecucionDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarEjecucion(EjecucionDTO ejecucionDTO) {
		// TODO Auto-generated method stub
		
	}

}
