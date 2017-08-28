package com.lazyloading.factoria;

import java.util.Locale;

import com.jcabi.aspects.Loggable;
import com.lazyloading.configuracion.UtilidadConfiguracionSistema;

public class FactoriaLocale {

	private static FactoriaLocale factoriaLocale;
	
	private Locale locale;
	
	@Loggable
	public Locale getLocale() {
		String lenguaje = UtilidadConfiguracionSistema.getLenguaje();
		String pais = UtilidadConfiguracionSistema.getPais();
		if(locale == null) {
			locale = new Locale.Builder().setLanguage(lenguaje).setRegion(pais).build();
		}
		return locale;
	}
	
	public static FactoriaLocale getFactoriaLocale() {
		if(factoriaLocale == null){
			factoriaLocale = new FactoriaLocale();
		}
		return factoriaLocale;
	}
	
}
