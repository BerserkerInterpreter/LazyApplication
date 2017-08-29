package com.lazyloading.test.factoria;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.factoria.FactoriaDiasPeriodo;
import com.lazyloading.modelo.Dia;
import com.lazyloading.modelo.DiasPeriodo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoriaDiasPeriodoTest {

	@Test
	public void testGetFactoriaDiasPeriodoExito() {
		FactoriaDiasPeriodo factoriaDiasPeriodo = FactoriaDiasPeriodo.getFactoriaDiasPeriodo();
		Assert.assertNotNull("TEST: La variable de referencia factoriaDiasPeriodo es igual a null.", factoriaDiasPeriodo);
	}
	
	@Test
	public void testGetDiasPeriodoExito() {
		String diasElementos = "5,4,30,30,1,1,3,20,20,20,11,1,2,3,4,5,6,7,8,9,10,11,6,9,19,29,39,49,59,10,32,56,76,8,44,60,47,85,71,91";
		FactoriaDiasPeriodo factoriaDiasPeriodo = FactoriaDiasPeriodo.getFactoriaDiasPeriodo();
		DiasPeriodo diasPeriodo = factoriaDiasPeriodo.getDiasPeriodo(diasElementos);
		Assert.assertNotNull("TEST: La variable de referencia diasPeriodo es igual a null.", diasPeriodo);
		this.verificarCantidadDiasPeriodo(diasPeriodo);
		this.verificarDias(diasPeriodo);
	}
	
	private void verificarCantidadDiasPeriodo(DiasPeriodo diasPeriodo) {
		Integer numeroDias = diasPeriodo.getNumeroDias();
		Integer numeroDiasEsperados = 5;
		Assert.assertEquals("TEST: El numero de dias no es el correcto (se esperan 5 dias).", numeroDiasEsperados, numeroDias);
	}

	private void verificarDias(DiasPeriodo diasPeriodo) {
		Set<Dia> listaDias = diasPeriodo.getListaDias();
		Integer numeroDiasEsperados = listaDias.size();
		Integer numeroDias = diasPeriodo.getNumeroDias();
		Assert.assertEquals("TEST: El tamano de la lista de dias no es igual al numero de dias en el periodo.", numeroDiasEsperados, numeroDias);
	}
}
