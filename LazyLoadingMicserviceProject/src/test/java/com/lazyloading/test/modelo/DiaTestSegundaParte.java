package com.lazyloading.test.modelo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.configuracion.UtilidadConfiguracionSistema;
import com.lazyloading.modelo.Dia;
import com.lazyloading.modelo.Elemento;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiaTestSegundaParte {

	@Test
	public void testAdicionarElementoListaNull() {
		Integer numeroDia = 1;
		Integer cantidadElementos = 2;
		Dia dia = this.crearDia(numeroDia, cantidadElementos);
		Integer pesoPrimerElemento = 20;
		Integer pesoSegundoElemento = 30;
		Elemento primerElemento = this.crearElemento(pesoPrimerElemento);
		Elemento segundoElemento = this.crearElemento(pesoSegundoElemento);
		dia.adicionarElemento(primerElemento);
		dia.adicionarElemento(segundoElemento);
		this.verificarDiaListaNull(dia);
	}

	private Elemento crearElemento(Integer valorPeso) {
		Elemento elemento = new Elemento();
		String unidadPeso = UtilidadConfiguracionSistema.getUnidadPeso();
		elemento.setPeso(valorPeso, unidadPeso);
		return elemento;
	}
	
	private Dia crearDia(Integer numeroDia, Integer cantidadElementos) {
		Dia dia = new Dia();
		dia.setNumeroDia(numeroDia);
		dia.setCantidadElementos(cantidadElementos);
		return dia;
	}
	
	private void verificarDiaListaNull(Dia dia) {
		List<Elemento> listaElementos = dia.getListaElementos();
		Assert.assertNotNull("TEST: La lista de elementos no puede ser igual a null.", listaElementos);
		Integer cantidadElementosEsperados = 2;
		Integer cantidadElementosActual = listaElementos.size();
		Assert.assertEquals("TEST: La cantidad de elementos en la lista no es la esperada (se esperan dos elementos)", 
				cantidadElementosEsperados, cantidadElementosActual);
	}
	
	@Test
	public void testAdicionarElementoListaNoNull() {
		Integer numeroDia = 1;
		Integer cantidadElementos = 2;
		Dia dia = this.crearDia(numeroDia, cantidadElementos);
		Integer pesoPrimerElemento = 20;
		Integer pesoSegundoElemento = 30;
		Elemento primerElemento = this.crearElemento(pesoPrimerElemento);
		Elemento segundoElemento = this.crearElemento(pesoSegundoElemento);
		List<Elemento> listaElementos = new ArrayList<>();
		dia.setListaElementos(listaElementos);
		dia.adicionarElemento(primerElemento);
		dia.adicionarElemento(segundoElemento);
		this.verificarDiaListaNoNull(dia);
	}

	private void verificarDiaListaNoNull(Dia dia) {
		List<Elemento> listaElementos = dia.getListaElementos();
		Assert.assertNotNull("TEST: La lista de elementos no puede ser igual a null.", listaElementos);
		Integer cantidadElementosEsperados = 2;
		Integer cantidadElementosActual = listaElementos.size();
		Assert.assertEquals("TEST: La cantidad de elementos en la lista no es la esperada (se esperan dos elementos)", 
				cantidadElementosEsperados, cantidadElementosActual);
	}
	
}
