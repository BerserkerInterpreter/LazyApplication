package com.lazyloading.test.modelo;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.configuracion.UtilidadConfiguracionSistema;
import com.lazyloading.excepcion.ExcepcionDias;
import com.lazyloading.modelo.Dia;
import com.lazyloading.modelo.Elemento;
import com.lazyloading.modelo.LineaImpresion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiaTestPrimeraParte {

	private Dia dia;
	
	@Before
	public void setUp() {
		Integer numeroDia = 1;
		Integer cantidadElementos = 4;
		Dia dia = this.obtenerDia(numeroDia, cantidadElementos);
		this.dia = dia;
	}
	
	@Test
	public void testVerificarElementosExito() {
		this.adicionarElemento(dia, 30);
		this.adicionarElemento(dia, 30);
		this.adicionarElemento(dia, 1);
		this.adicionarElemento(dia, 1);
		List<Elemento> listaElementos = dia.getListaElementos();
		Collections.sort(listaElementos);
		LineaImpresion lineaImpresion = dia.verificarElementos();
		this.verificarLineaImpresion(lineaImpresion);
		
	}
	
	private Dia obtenerDia(Integer numeroDia, Integer cantidadElementos) {
		Dia dia = new Dia();
		dia.setNumeroDia(numeroDia);
		dia.setCantidadElementos(cantidadElementos);
		return dia;
	}

	private void adicionarElemento(Dia dia, Integer valorPeso) {
		Elemento elemento = new Elemento();
		String unidadPeso = UtilidadConfiguracionSistema.getUnidadPeso();
		elemento.setPeso(valorPeso, unidadPeso);
		dia.adicionarElemento(elemento);
	}
	
	private void verificarLineaImpresion(LineaImpresion lineaImpresion) {
		Assert.assertNotNull("TEST: La linea de impresion procesada es igual a null.", lineaImpresion);
		Dia dia = lineaImpresion.getDia();
		Assert.assertNotNull("TEST: El dia recuperado de la linea de impresion es igual a null.", dia);
		Integer numeroDia = dia.getNumeroDia();
		Assert.assertNotNull("TEST: El numero de dia es igual a null.", numeroDia);
		Integer numeroDiaEsperado = 1;
		Assert.assertEquals("TEST: El numero de dia no es igual a uno (numero de dia esperado).", numeroDia, numeroDiaEsperado);
		Integer numeroBolsasEsperadas = 2;
		Integer numeroBolsas = lineaImpresion.getNumeroBolsas();
		Assert.assertNotNull("TEST: El numero de bolsas no puede ser igual a null.", numeroBolsas);
		Assert.assertEquals("TEST: El numero de bolsas no es igual a dos (se esperan dos bolsas)", numeroBolsas, numeroBolsasEsperadas);
		String descripcionLineaImpresion = lineaImpresion.getDescripcionLinea();
		Assert.assertNotNull("TEST: La descripcion de la linea de impresion no puede ser igual a null.", descripcionLineaImpresion);
	}
	
	@Test(expected = ExcepcionDias.class)
	public void testVerificarElementosFallo() {
		List<Elemento> listaElementos = null;
		dia.setListaElementos(listaElementos);
		LineaImpresion listaLineaImpresion = dia.verificarElementos();
	}
}
