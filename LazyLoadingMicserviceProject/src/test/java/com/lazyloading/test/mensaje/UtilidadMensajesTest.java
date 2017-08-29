package com.lazyloading.test.mensaje;

import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.constante.ConstanteMensajes;
import com.lazyloading.factoria.FactoriaLocale;
import com.lazyloading.mensaje.UtilidadMensajes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilidadMensajesTest {

	@Test
	public void testBuscarMensajeExito() {
		String resourceKey = ConstanteMensajes.OBTENER_INTEGER.getKey();
		FactoriaLocale factoriaLocale = FactoriaLocale.getFactoriaLocale();
		Locale locale = factoriaLocale.getLocale();
		String mensaje = UtilidadMensajes.buscarMensaje(resourceKey, locale);
		Assert.assertNotNull("TEST: El mensaje recuperado es igual a null.", mensaje);
		Assert.assertNotEquals("TEST: El mensaje recuperado se encuentra vacio.", "", mensaje);
	}
	
	@Test(expected = MissingResourceException.class)
	public void testBuscarMensajeFalloKey() {
		String resourceKey = "com.lazyloading.mensajes.excepcion.obtenerfloat";
		FactoriaLocale factoriaLocale = FactoriaLocale.getFactoriaLocale();
		Locale locale = factoriaLocale.getLocale();
		UtilidadMensajes.buscarMensaje(resourceKey, locale);
	}
	
	@Test(expected = MissingResourceException.class)
	public void testBuscarMensajeFalloResourceBundle() {
		Locale defaultLocale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
		Locale.setDefault(defaultLocale);
		String resourceKey = ConstanteMensajes.OBTENER_INTEGER.getKey();
		Locale locale = new Locale.Builder().setLanguage("en").setRegion("AR").build();
		UtilidadMensajes.buscarMensaje(resourceKey, locale);
	}
	
}
