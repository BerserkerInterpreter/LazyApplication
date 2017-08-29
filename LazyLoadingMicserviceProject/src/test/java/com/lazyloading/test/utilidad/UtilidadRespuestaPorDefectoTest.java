package com.lazyloading.test.utilidad;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.modelo.LineaImpresion;
import com.lazyloading.utilidad.UtilidadRespuestaPorDefecto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilidadRespuestaPorDefectoTest {

	@Test
	public void testObtenerLineaImpresion() {
		Set<LineaImpresion> listaLineaImpresion =
				UtilidadRespuestaPorDefecto.obtenerLineaImpresion();
		
		Assert.assertNotNull("TEST: La lista de linea de impresion por defecto es igual a null.", listaLineaImpresion);
		
		LineaImpresion lineaImpresion = null;
		for(Iterator<LineaImpresion> iterator = listaLineaImpresion.iterator(); 
				iterator.hasNext();) {
			lineaImpresion = iterator.next();
		}
	
		Assert.assertNotNull("TEST: La linea de impresion es igual a null.", lineaImpresion);
		
		int codigo = lineaImpresion.getCodigo();
		int codigoEsperado = -1;
		Assert.assertEquals("TEST: El codigo esperado (-1) no fue el obtenido.", codigoEsperado, codigo);
		
		String descripcionLinea = lineaImpresion.getDescripcionLinea();
		Assert.assertNotNull("TEST: La descripcion de la linea es igual a null.", descripcionLinea);
		Assert.assertNotEquals("TEST: La descripcion de la linea de impresion esta vacia.", "", descripcionLinea);
		
	}

}
