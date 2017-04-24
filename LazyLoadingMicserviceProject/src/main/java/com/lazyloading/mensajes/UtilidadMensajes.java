package com.lazyloading.mensajes;

import java.util.Locale;
import java.util.ResourceBundle;

import com.jcabi.aspects.Loggable;
import com.lazyloading.configuracion.UtilidadConfiguracionSistema;

public class UtilidadMensajes {
	
	@Loggable
	public static String buscarMensaje(String key, Locale locale) {
		
		String baseResourceBundle = UtilidadConfiguracionSistema.getResBundleMensajesBaseName();
		
		ResourceBundle resourceBundle =
				ResourceBundle.getBundle(baseResourceBundle, locale);
		String mensaje = resourceBundle.getString(key);
		
		return mensaje;
		
	}
	
}
