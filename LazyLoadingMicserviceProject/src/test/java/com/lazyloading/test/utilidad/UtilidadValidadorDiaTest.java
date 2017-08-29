package com.lazyloading.test.utilidad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.excepcion.ExcepcionVerificarAtrasListaElementos;
import com.lazyloading.excepcion.ExcepcionVerificarListaElementos;
import com.lazyloading.modelo.Elemento;
import com.lazyloading.utilidad.UtilidadValidadorDia;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilidadValidadorDiaTest {

	@Test(expected = ExcepcionVerificarListaElementos.class)
	public void testVerificarListaElementosNull() {
		List<Elemento> listaElementos = null;
		UtilidadValidadorDia.verificarListaElementos(listaElementos);
	}
	
	@Test(expected = ExcepcionVerificarListaElementos.class)
	public void testVerificarListaElementosVacia() {
		List<Elemento> listaElementos = new LinkedList<>();
		UtilidadValidadorDia.verificarListaElementos(listaElementos);
	}
	
	@Test
	public void testVerificarListaElementosExitoso() {
		List<Elemento> listaElementos = new LinkedList<>();
		Elemento elemento = new Elemento();
		elemento.setCodigo(1);
		elemento.setEstado("ACTIVO");
		listaElementos.add(elemento);
		UtilidadValidadorDia.verificarListaElementos(listaElementos);
	}
	
	@Test(expected = ExcepcionVerificarAtrasListaElementos.class)
	public void testVerificarAtrasListaElementosMayorFallo() {
		int atras = 2;
		List<Elemento> listaElementos = new ArrayList<>();
		Elemento elemento = new Elemento();
		elemento.setCodigo(2);
		elemento.setEstado("INACTIVO");
		listaElementos.add(elemento);
		UtilidadValidadorDia.verificarAtrasListaElementos(atras, listaElementos);
	}
	
	@Test(expected = ExcepcionVerificarAtrasListaElementos.class)
	public void testVerificarAtrasListaElementosIgualFallo() {
		int atras = 1;
		List<Elemento> listaElementos = new ArrayList<>();
		Elemento elemento = new Elemento();
		elemento.setCodigo(2);
		elemento.setEstado("INACTIVO");
		listaElementos.add(elemento);
		UtilidadValidadorDia.verificarAtrasListaElementos(atras, listaElementos);
	}
	
	@Test
	public void testVerificarAtrasListaElementosExitoso() {
		int atras = 0;
		List<Elemento> listaElementos = new ArrayList<>();
		Elemento elemento = new Elemento();
		elemento.setCodigo(2);
		elemento.setEstado("INACTIVO");
		listaElementos.add(elemento);
		UtilidadValidadorDia.verificarAtrasListaElementos(atras, listaElementos);
	}
}
