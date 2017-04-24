package com.lazyloading.utilidades;

import java.util.Locale;

import com.jcabi.aspects.Loggable;
import com.lazyloading.constantes.ConstanteMensajes;
import com.lazyloading.excepciones.ExcepcionObtenerInteger;
import com.lazyloading.excepciones.ExcepcionVerificarArrayDiasElementos;
import com.lazyloading.excepciones.ExcepcionVerificarContadorArrDiasElementos;
import com.lazyloading.excepciones.ExcepcionVerificarDiasElementos;
import com.lazyloading.excepciones.ExcepcionVerificarVecesDos;
import com.lazyloading.excepciones.ExcepcionVerificarVecesUno;
import com.lazyloading.factorias.FactoriaLocale;
import com.lazyloading.mensajes.UtilidadMensajes;

public final class UtilidadValidadorDiasPeriodo {
	
	@Loggable
	public static int obtenerInteger(String strValor) throws ExcepcionObtenerInteger{
		int valor = 0;
		try {
			valor = Integer.parseInt(strValor);
		} catch(NumberFormatException nfe) {
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String key = ConstanteMensajes.OBTENER_INTEGER.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionObtenerInteger(mensajeError, nfe);
		}
		return valor;
	}
	
	@Loggable
	public static void verificarDiasElementos(String diasElementos) throws ExcepcionVerificarDiasElementos {
		if(diasElementos == null
				|| diasElementos.isEmpty()) {
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String key = ConstanteMensajes.VERIFICAR_DIAS_ELEMENTOS.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarDiasElementos(mensajeError);
		}
	}
	
	@Loggable
	public static void verificarArrayDiasElementos(String[] arrayDiasElementos) throws ExcepcionVerificarArrayDiasElementos {
		if(arrayDiasElementos == null
				|| arrayDiasElementos.length == 0) {
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String key = ConstanteMensajes.VERIFICAR_ARRAY_DIAS_ELEMENTOS.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarArrayDiasElementos(mensajeError);
		}
	}
	
	@Loggable
	public static void verificarVeces(String veces) throws ExcepcionVerificarVecesUno {
		if(veces == null
				|| veces.isEmpty()) {
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String key = ConstanteMensajes.VERIFICAR_VECES_UNO.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarVecesUno(mensajeError);
		}
	}
	
	@Loggable
	public static void verificarVeces(int veces, String[] arrayDiasElementos) throws ExcepcionVerificarVecesDos {
		if(veces > arrayDiasElementos.length) {
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String key = ConstanteMensajes.VERIFICAR_VECES_DOS.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarVecesDos(mensajeError);
		}
	}
	
	@Loggable
	public static void verificarContadorArrDiasElementos(int contadorArrDiasElementos, String[] arrayDiasElementos) 
			throws ExcepcionVerificarContadorArrDiasElementos {
		if(contadorArrDiasElementos >= arrayDiasElementos.length) {
			Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
			String key = ConstanteMensajes.VERIFICAR_CONTADOR_ARR_DIAS_ELEMENTOS.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarContadorArrDiasElementos(mensajeError);
		}
	}
	
}
