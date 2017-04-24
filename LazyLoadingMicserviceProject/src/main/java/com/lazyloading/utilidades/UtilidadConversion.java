package com.lazyloading.utilidades;

import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcabi.aspects.Loggable;

public final class UtilidadConversion {

	private UtilidadConversion() {
		super();
	}

	@Loggable
	public static String convertirListaJSON(Collection<?> listaElementos) {
		
		Gson gson = new GsonBuilder().create();
		String listaLineaImpresionJSON = gson.toJson(listaElementos);
		
		return listaLineaImpresionJSON;
		
	}
}
