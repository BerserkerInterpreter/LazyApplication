package com.lazyloading.test.controlador;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.controlador.ControladorNumMaxViajes;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControladorNumMaxViajesTest {

	@Test
	public void testGetControladorNumMaxViajes() {
		ControladorNumMaxViajes controladorNumMaxViajes =
				ControladorNumMaxViajes.getControladorNumMaxViajes();
		Assert.assertNotNull("TEST: La variable controladorNumMaxViajes es igual a null.", controladorNumMaxViajes);
	}
	
	@Test
	public void testDeterminarNumMaxViajesExito() {
		String diasElementos = "5,4,30,30,1,1,3,20,20,20,11,1,2,3,4,5,6,7,8,9,10,11,6,9,19,29,39,49,59,10,32,56,76,8,44,60,47,85,71,91";
		ControladorNumMaxViajes controladorNumMaxViajes =
				ControladorNumMaxViajes.getControladorNumMaxViajes();
		String listaLineaImpresionJSON = controladorNumMaxViajes.determinarMaxNumViajes(diasElementos);
		Assert.assertNotNull("TEST: El string json de lineas de impresion es igual a null.", listaLineaImpresionJSON);
		Assert.assertNotEquals("TEST: El string json de lineas de impresion esta vacio.", "", listaLineaImpresionJSON);
	}
	
}
