package com.lazyloading.test.modelo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.configuracion.UtilidadConfiguracionSistema;
import com.lazyloading.modelo.Dia;
import com.lazyloading.modelo.DiasPeriodo;
import com.lazyloading.modelo.Elemento;
import com.lazyloading.modelo.LineaImpresion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiasPeriodoTest {

	@Test
	public void testVerificarDias() {
		DiasPeriodo diasPeriodo = new DiasPeriodo();
		Integer numeroDias = 1;
		diasPeriodo.setNumeroDias(numeroDias);
		this.adicionarDia(diasPeriodo);
		this.verificarLineaImpresion(diasPeriodo);
	}

	private void adicionarDia(DiasPeriodo diasPeriodo) {
		Integer numeroDia = 1;
		Integer cantidadElementos = 4;
		Dia primerDia = this.obtenerDia(numeroDia, cantidadElementos);
		this.adicionarElemento(primerDia, 30);
		this.adicionarElemento(primerDia, 30);
		this.adicionarElemento(primerDia, 1);
		this.adicionarElemento(primerDia, 1);
		List<Elemento> listaElementos = primerDia.getListaElementos();
		Collections.sort(listaElementos);
		Set<Dia> listaDias = new TreeSet<>();
		diasPeriodo.setListaDias(listaDias);
		diasPeriodo.adicionarDia(primerDia);
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
	
	private void verificarLineaImpresion(DiasPeriodo diasPeriodo) {
		Set<LineaImpresion> listaLineaImpresion = 
				diasPeriodo.verificarDias();
		Assert.assertNotNull("TEST: La lista de lineas de impresion es igual a null.", listaLineaImpresion);
		LineaImpresion lineaImpresion = null;
		for(Iterator<LineaImpresion> iterator = listaLineaImpresion.iterator(); 
				iterator.hasNext();) {
			lineaImpresion = iterator.next();
			break;
		}
		Dia dia = lineaImpresion.getDia();
		Assert.assertNotNull("TEST: El dia recuperado de la linea de impresion es igual a null.", dia);
		Integer numeroDiaEsperado = 1;
		Integer numeroDia = dia.getNumeroDia();
		Assert.assertNotNull("TEST: El numero de dia es igual a null.", numeroDia);
		Assert.assertEquals("TEST: El numero de dia no es igual a uno.", numeroDiaEsperado, numeroDia);
		Integer numeroBolsasEsperado = 2;
		Integer numeroBolsas = lineaImpresion.getNumeroBolsas();
		Assert.assertNotNull("TEST: El numero de bolsas es igual a null.", numeroBolsas);
		Assert.assertEquals("TEST: El numero de bolsas no es igual a dos.", numeroBolsasEsperado, numeroBolsas);
		String descripcionLinea = lineaImpresion.getDescripcionLinea();
		Assert.assertNotNull("TEST: La descripcion de la linea es igual a null.", descripcionLinea);
	}
}
