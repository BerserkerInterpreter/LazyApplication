package com.lazyloading.utilidades;

import java.util.List;
import java.util.Locale;

import com.jcabi.aspects.Loggable;
import com.lazyloading.constantes.ConstanteMensajes;
import com.lazyloading.excepciones.ExcepcionVerificarAtrasListaElementos;
import com.lazyloading.excepciones.ExcepcionVerificarListaElementos;
import com.lazyloading.factorias.FactoriaLocale;
import com.lazyloading.mensajes.UtilidadMensajes;
import com.lazyloading.modelo.Elemento;

public final class UtilidadValidadorDia {
	
	private UtilidadValidadorDia() {}
	
	@Loggable
	public static void verificarListaElementos(List<Elemento> listaElementos) throws ExcepcionVerificarListaElementos {
		
		Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
		
		if(listaElementos == null) {
			String key = ConstanteMensajes.VERIFICAR_LISTA_ELEMENTOS_NULL.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarListaElementos(mensajeError);
		} else if(listaElementos.isEmpty()) {
			String key = ConstanteMensajes.VERIFICAR_LISTA_ELEMENTOS_VACIA.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarListaElementos(mensajeError);
		}
		
	}
	
	@Loggable
	public static void verificarAtrasListaElementos(int atras, List<Elemento> listaElementos) 
				throws ExcepcionVerificarAtrasListaElementos {
		
		Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
		
		if(atras >= listaElementos.size() ) {
			String key = ConstanteMensajes.VERIFICAR_ATRAS_LISTA_ELEMENTOS.getKey();
			String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
			throw new ExcepcionVerificarAtrasListaElementos(mensajeError);
		}
		
	}
	
}
