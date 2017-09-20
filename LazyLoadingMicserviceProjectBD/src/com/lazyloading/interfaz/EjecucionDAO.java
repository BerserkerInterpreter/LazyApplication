package com.lazyloading.dao.interfaz;

import com.lazyloading.dto.EjecucionDTO;

public interface EjecucionDAO {
	
	public abstract void adicionarEjecucion(EjecucionDTO ejecucionDTO);
	
	public abstract EjecucionDTO buscarEjecucion(String codigoEjecucion);
	
	public abstract void actualizarEjecucion(EjecucionDTO ejecucionDTO);
	
	public abstract void eliminarEjecucion(EjecucionDTO ejecucionDTO);
	
}
