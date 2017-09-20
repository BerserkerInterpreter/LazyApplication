package com.lazyloading.controlador;

import com.lazyloading.configuracion.ConstanteConfiguracion;
import com.lazyloading.constante.ConstanteMensajes;
import com.lazyloading.dao.interfaz.EjecucionDAO;
import com.lazyloading.db.factoria.FactoriaEjecucionDAO;
import com.lazyloading.dto.RespuestaDTO;
import com.lazyloading.excepcion.ExcepcionControladorEjecucion;
import com.lazyloading.mensaje.UtilidadMensajes;
import com.lazyloading.modelo.Ejecucion;

public class ControladorEjecucion implements IControladorEjecucion {

	@Override
	public RespuestaDTO registrarEjecucion(String datosEjecucion) {
		RespuestaDTO resultadoDTO = this.procesarResultadoExito();
		try {
			this.validarDatosEjecucionNull(datosEjecucion);
			this.validarDatosEjecucionVacio(datosEjecucion);
			Ejecucion ejecucion = new Ejecucion(datosEjecucion);
			this.validarEjecucion(ejecucion);
			EjecucionDAO ejecucionDAO = FactoriaEjecucionDAO.getFactoriaEjecucionDAO().getEjecucionDAO();
			ejecucionDAO.adicionarEjecucion(ejecucion);
		} catch (Exception ex) {
			ex.printStackTrace();
			resultadoDTO = this.procesarResultadoError();
		}
		return resultadoDTO;
	}
	
	private RespuestaDTO procesarResultadoError() {
		String resourceBundleConfiguracion = ConstanteConfiguracion.NOMBRE_RESOURCE_BUNDLE_CONFIGURACION.getKey();
		String codigoResultado = UtilidadMensajes.buscarMensaje(
						resourceBundleConfiguracion,
						ConstanteConfiguracion.CODIGO_RESULTADO_ERROR.getKey());
		String mensajeError = UtilidadMensajes.buscarMensaje(
				resourceBundleConfiguracion,
				ConstanteConfiguracion.MENSAJE_EJECUCION_ERROR.getKey());
		RespuestaDTO respuestaDTO = this.procesarResultado(codigoResultado, mensajeError);
		return respuestaDTO;
	}
	
	private RespuestaDTO procesarResultadoExito() {
		String resourceBundleConfiguracion = ConstanteConfiguracion.NOMBRE_RESOURCE_BUNDLE_CONFIGURACION.getKey();
		String codigoResultado = UtilidadMensajes.buscarMensaje(
				resourceBundleConfiguracion,
				ConstanteConfiguracion.CODIGO_RESULTADO_EXITO.getKey());
		String mensajeExito = UtilidadMensajes.buscarMensaje(
				resourceBundleConfiguracion,
				ConstanteConfiguracion.MENSAJE_EJECUCION_EXITO.getKey());
		RespuestaDTO respuestaDTO = this.procesarResultado(codigoResultado, mensajeExito);
		return respuestaDTO;
	}
	
	private RespuestaDTO procesarResultado(String codigoResultado, String mensajeResultado) { 
		RespuestaDTO respuestaDTO = new RespuestaDTO(codigoResultado, mensajeResultado);
		return respuestaDTO;
	}

	private void validarEjecucion(Ejecucion ejecucion) {
		this.validarNumeroIdentificacionEjecucion(ejecucion);
		this.validarFechaEjecucion(ejecucion);
		this.validarLineasImpresion(ejecucion);
	}

	private void validarNumeroIdentificacionEjecucion(Ejecucion ejecucion) {
		if(ejecucion.getNumeroIdentificacion() == null) {
			String mensajeExcepcion = UtilidadMensajes.buscarMensaje(ConstanteMensajes.ERROR_NUMERO_IDENTIFACION_EJECUCION.getKey());
			throw new ExcepcionControladorEjecucion(mensajeExcepcion);
		}
	}
	
	private void validarFechaEjecucion(Ejecucion ejecucion) {
		if(ejecucion.getFecha() == null
				|| ejecucion.getFecha().toString().length() == 0) {
			String mensajeExcepcion = UtilidadMensajes.buscarMensaje(ConstanteMensajes.ERROR_VALIDAR_FECHA_EJECUCION.getKey());
			throw new ExcepcionControladorEjecucion(mensajeExcepcion);
		}
	}
	
	private void validarLineasImpresion(Ejecucion ejecucion) {
		if(ejecucion.getListaLineaImpresion() == null
				|| ejecucion.getListaLineaImpresion().isEmpty()) {
			String mensajeExcepcion = UtilidadMensajes.buscarMensaje(ConstanteMensajes.ERROR_VALIDAR_LINEAS_IMPRESION.getKey());
			throw new ExcepcionControladorEjecucion(mensajeExcepcion);
		}
	}
	
	private void validarDatosEjecucionNull(String datosEjecucion) {
		if(datosEjecucion == null) {
			String mensaje = UtilidadMensajes.buscarMensaje(ConstanteMensajes.DATOS_EJECUCION_NULL.getKey());
			throw new ExcepcionControladorEjecucion(mensaje);
		} else if(datosEjecucion.isEmpty()) {
			String mensaje = UtilidadMensajes.buscarMensaje(ConstanteMensajes.DATOS_EJECUCION_VACIO.getKey());
			throw new ExcepcionControladorEjecucion(mensaje);
		}
	}
	
	private void validarDatosEjecucionVacio(String datosEjecucion) {
		if(datosEjecucion.isEmpty()) {
			String mensaje = UtilidadMensajes.buscarMensaje(ConstanteMensajes.DATOS_EJECUCION_NULL.getKey());
			throw new ExcepcionControladorEjecucion(mensaje);
		}
	}
}
