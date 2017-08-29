package com.lazyloading.test.utilidad;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.excepcion.ExcepcionObtenerInteger;
import com.lazyloading.excepcion.ExcepcionVerificarArrayDiasElementos;
import com.lazyloading.excepcion.ExcepcionVerificarContadorArrDiasElementos;
import com.lazyloading.excepcion.ExcepcionVerificarDiasElementos;
import com.lazyloading.excepcion.ExcepcionVerificarVecesDos;
import com.lazyloading.excepcion.ExcepcionVerificarVecesUno;
import com.lazyloading.utilidad.UtilidadValidadorDiasPeriodo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilidadValidadorDiasPeriodoTest {

	@Test
	public void testObtenerIntegerExitoso() {
		String numeroEntrada = "24";
		int numeroEsperado = 24;
		int numeroResultado = UtilidadValidadorDiasPeriodo.obtenerInteger(numeroEntrada);
		String mensajeError = "TEST: El numero esperado y el numero procesado no son iguales.";
		assertEquals(mensajeError, numeroEsperado, numeroResultado);
	}

	@Test(expected = ExcepcionObtenerInteger.class)
	public void testObtenerIntegerFalla() {
		String numeroEntrada = "H";
		UtilidadValidadorDiasPeriodo.obtenerInteger(numeroEntrada);
	}
	
	@Test(expected = ExcepcionVerificarDiasElementos.class)
	public void testVerificarDiasElementosNull() {
		String diasElementos = null;
		UtilidadValidadorDiasPeriodo.verificarDiasElementos(diasElementos);
	}
	
	@Test(expected = ExcepcionVerificarDiasElementos.class)
	public void testVerificarDiasElementosVacio() {
		String diasElementos = "";
		UtilidadValidadorDiasPeriodo.verificarDiasElementos(diasElementos);
	}
	
	@Test
	public void testVerificarDiasElementosExitoso() {
		String diasElementos = "1,2,3,4,5";
		UtilidadValidadorDiasPeriodo.verificarDiasElementos(diasElementos);
	}
	
	@Test(expected = ExcepcionVerificarArrayDiasElementos.class)
	public void testVerificarArrayDiasElementosNull() {
		String arrayDiasElementos[] = null;
		UtilidadValidadorDiasPeriodo.verificarArrayDiasElementos(arrayDiasElementos);
	}
	
	@Test(expected = ExcepcionVerificarArrayDiasElementos.class)
	public void testVerificarArrayDiasElementosVacio() {
		String arrayDiasElementos[] = new String[0];
		UtilidadValidadorDiasPeriodo.verificarArrayDiasElementos(arrayDiasElementos);
	}
	
	@Test
	public void testVerificarArrayDiasElementosExitoso() {
		String arrayDiasElementos[] = new String[4];
		UtilidadValidadorDiasPeriodo.verificarArrayDiasElementos(arrayDiasElementos);
	}

	@Test(expected = ExcepcionVerificarVecesUno.class)
	public void testVerificarCantidadDiasPeriodoNull() {
		String cantidadDiasPeriodo = null;
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(cantidadDiasPeriodo);
	}
	
	@Test(expected = ExcepcionVerificarVecesUno.class)
	public void testVerificarCantidadDiasPeriodoVacio() {
		String cantidadDiasPeriodo = "";
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(cantidadDiasPeriodo);
	}
	
	@Test
	public void testVerificarCantidadDiasPeriodoExitoso() {
		String cantidadDiasPeriodo = "4";
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(cantidadDiasPeriodo);
	}
	
	@Test(expected = ExcepcionVerificarVecesDos.class)
	public void testVerificarCantidadDiasPeriodoArray() {
		int veces = 4;
		String[] arrayDiasElementos = new String[2];
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(veces, arrayDiasElementos);
	}
	
	@Test
	public void testVerificarCantidadDiasPeriodoArrayIgualExitoso() {
		int veces = 4;
		String[] arrayDiasElementos = new String[4];
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(veces, arrayDiasElementos);
	}
	
	@Test
	public void testVerificarCantidadDiasPeriodoArrayMayorExitoso() {
		int veces = 4;
		String[] arrayDiasElementos = new String[5];
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(veces, arrayDiasElementos);
	}
	
	@Test(expected = ExcepcionVerificarContadorArrDiasElementos.class)
	public void testVerificarContadorArrDiasElementos() {
		int contadorArrDiasElementos = 4;
		String[] arrayDiasElementos = new String[2];
		UtilidadValidadorDiasPeriodo.verificarContadorArrDiasElementos(contadorArrDiasElementos, arrayDiasElementos);
	}
	
}
