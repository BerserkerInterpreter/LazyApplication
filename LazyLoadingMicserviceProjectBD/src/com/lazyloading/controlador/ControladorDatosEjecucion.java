package com.lazyloading.controlador;

import com.lazyloading.dto.EjecucionDTO;
import com.lazyloading.utilidad.UtilidadValidadorFachadaHttpServlet;

public class ControladorDatosEjecucion implements Controlador {

	@Override
	public void registrarEjecucion(String datosEjecucion) {
		UtilidadValidadorFachadaHttpServlet.validarDatosEjecucionNull(datosEjecucion);
		UtilidadValidadorFachadaHttpServlet.validarDatosEjecucionVacio(datosEjecucion);
		EjecucionDTO ejecucionDTO = new EjecucionDTO();
		ejecucionDTO.procesarEjecucion(datosEjecucion);
	}
}
