package com.lazyloading.utilidades;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.jcabi.aspects.Loggable;
import com.lazyloading.constantes.ConstanteMensajes;
import com.lazyloading.factorias.FactoriaLocale;
import com.lazyloading.mensajes.UtilidadMensajes;
import com.lazyloading.modelo.LineaImpresion;

public class UtilidadRespuestaPorDefecto {

	public UtilidadRespuestaPorDefecto() {
		super();
	}

	@Loggable
	public static Set<LineaImpresion> obtenertLineaImpresion() {
		
		Locale locale = FactoriaLocale.getFactoriaLocale().getLocale();
		String key = ConstanteMensajes.OBTENER_LINEA_IMPRESION.getKey();
		String mensajeError = UtilidadMensajes.buscarMensaje(key, locale);
		
		LineaImpresion lineaImpresion = 
				new LineaImpresion();
		lineaImpresion.setCodigo(-1);
		lineaImpresion.setDescripcionLinea(mensajeError);
		
		Set<LineaImpresion> listaLineaImpresion = new TreeSet<>();
		listaLineaImpresion.add(lineaImpresion);
		
		return listaLineaImpresion;
	}
	
}
