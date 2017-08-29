package com.lazyloading.test.configuracion;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.configuracion.UtilidadConfiguracionSistema;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilidadConfiguracionSistemaTest {

	@Test
	public void testResBundleMensajesBaseName() {
		String nombreResourceBundleMensajes = UtilidadConfiguracionSistema.getResBundleMensajesBaseName();
		Assert.assertNotNull("TEST: El nombre del paquete de mensajes principal es igual a null.", nombreResourceBundleMensajes);
		Assert.assertNotEquals("TEST: El nombre del paquete de mensajes principal esta vacio.", "", nombreResourceBundleMensajes);
	}
	
	@Test
	public void testGetLenguaje() {
		String lenguaje = UtilidadConfiguracionSistema.getLenguaje();
		Assert.assertNotNull("TEST: El valor del lenguaje es igual a null.", lenguaje);
		Assert.assertNotEquals("TEST: El valor del lenguaje esta vacio.", "", lenguaje);
	}

	@Test
	public void testPais() {
		String pais = UtilidadConfiguracionSistema.getPais();
		Assert.assertNotNull("TEST: El valor del pais es igual a null.", pais);
		Assert.assertNotEquals("TEST: El valor del pais esta vacio.", "", pais);
	}
	
	@Test
	public void testSeparador() {
		String separador = UtilidadConfiguracionSistema.getSeparador();
		Assert.assertNotNull("TEST: El valor del separador es igual a null.", separador);
		Assert.assertNotEquals("TEST: El valor del separador esta vacio.", "", separador);
	}
	
	@Test
	public void testReemplazo() {
		String reemplazo = UtilidadConfiguracionSistema.getReemplazo();
		Assert.assertNotNull("TEST: El valor del reemplazo es igual a null.", reemplazo);
		Assert.assertNotEquals("TEST: El valor del reemplazo esta vacio.", "", reemplazo);
	}
	
	@Test
	public void testUnidadPeso() {
		String unidadPeso = UtilidadConfiguracionSistema.getUnidadPeso();
		Assert.assertNotNull("TEST: El valor de la unidad de peso es igual a null.", unidadPeso);
		Assert.assertNotEquals("TEST: El valor de la unidad de peso esta vacio.", "", unidadPeso);
	}
	
	@Test
	public void testLoggingPath() {
		String loggingPath = UtilidadConfiguracionSistema.getLoggingPath();
		Assert.assertNotNull("TEST: El valor del path de logs es igual a null.", loggingPath);
		Assert.assertNotEquals("TEST: El valor del path de logs esta vacio.", "", loggingPath);
	}
	
	@Test
	public void testLoggingSystemProperty() {
		String loggingSystemProperty = UtilidadConfiguracionSistema.getLoggingSystemProperty();
		Assert.assertNotNull("TEST: El valor de la propiedad logging system es igual a null.", loggingSystemProperty);
		Assert.assertNotEquals("TEST: El valor de la propiedad logging system esta vacio.", "", loggingSystemProperty);
	}
}
