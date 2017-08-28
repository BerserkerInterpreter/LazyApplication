package com.lazyloading.factoria;

import com.jcabi.aspects.Loggable;
import com.lazyloading.configuracion.UtilidadConfiguracionSistema;
import com.lazyloading.excepcion.ExcepcionDiasPeriodo;
import com.lazyloading.modelo.Dia;
import com.lazyloading.modelo.DiasPeriodo;
import com.lazyloading.modelo.Elemento;
import com.lazyloading.utilidad.UtilidadValidadorDiasPeriodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Set;
import java.util.TreeSet;

public class FactoriaDiasPeriodo {

	private static FactoriaDiasPeriodo factoriaDiasPeriodo;
	
	private Integer contadorArrayDiasElementos;
	
	private FactoriaDiasPeriodo() {}
	
	@Loggable(Loggable.INFO)
	public DiasPeriodo getDiasPeriodo(String diasElementos) throws ExcepcionDiasPeriodo {
		UtilidadValidadorDiasPeriodo.verificarDiasElementos(diasElementos);
		String[] arrayDiasElementos = this.obtenerArrayDiasElementos(diasElementos);
		UtilidadValidadorDiasPeriodo.verificarArrayDiasElementos(arrayDiasElementos);
		contadorArrayDiasElementos = 0;
		Integer cantidadDiasPeriodo = this.obtenerCantidadDiasPeriodo(arrayDiasElementos);
		DiasPeriodo diasPeriodo = new DiasPeriodo();
		diasPeriodo.setNumeroDias(cantidadDiasPeriodo);
		Set<Dia> listaDiasEnPeriodo = this.obtenerDiasPeriodo(cantidadDiasPeriodo, arrayDiasElementos);
		diasPeriodo.setListaDias(listaDiasEnPeriodo);
		return diasPeriodo;
	}
	
	private String[] obtenerArrayDiasElementos(String diasElementos) {
		String separador = UtilidadConfiguracionSistema.getSeparador();
		String reemplazo = UtilidadConfiguracionSistema.getReemplazo();
		diasElementos = diasElementos.replace(separador, reemplazo);
		String[] arrayDiasElementos = diasElementos.split(reemplazo);
		return arrayDiasElementos;
	}
	
	private Integer obtenerCantidadDiasPeriodo(String[] arrayDiasElementos) {
		String strCantidadDiasPeriodo = arrayDiasElementos[contadorArrayDiasElementos];
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(strCantidadDiasPeriodo);
		Integer cantidadDiasPeriodo = UtilidadValidadorDiasPeriodo.obtenerInteger(strCantidadDiasPeriodo);
		UtilidadValidadorDiasPeriodo.verificarCantidadDiasPeriodo(cantidadDiasPeriodo, arrayDiasElementos);
		contadorArrayDiasElementos++;
		return cantidadDiasPeriodo;
	}
	
	private Dia obtenerDia(int numeroDia, int cantidadElementos) {
		Dia dia = new Dia();
		dia.setNumeroDia(numeroDia);
		dia.setCantidadElementos(cantidadElementos);
		return dia;
	}
	
	private List<Elemento> obtenerElementosDia(
			Integer cantidadElementos,
			String[] arrayDiasElementos) {
		List<Elemento> listaElementos = 
				new ArrayList<>();
		Integer pesoElemento = 0;
		for(int j = 0; j < cantidadElementos; j++) {
			UtilidadValidadorDiasPeriodo.verificarContadorArrDiasElementos(contadorArrayDiasElementos, arrayDiasElementos);
			String strPesoElemento = arrayDiasElementos[contadorArrayDiasElementos];
			pesoElemento = UtilidadValidadorDiasPeriodo.obtenerInteger(strPesoElemento);
			contadorArrayDiasElementos++;
			Elemento elemento = new Elemento();
			String unidadPeso = UtilidadConfiguracionSistema.getUnidadPeso();
			elemento.setPeso(pesoElemento, unidadPeso);
			listaElementos.add(elemento);
		}
		return listaElementos;
	}
	
	private Set<Dia> obtenerDiasPeriodo(
			Integer cantidadDiasPeriodo, String arrayDiasElementos[]) {
		Set<Dia> listaDias = new TreeSet<>();
		Integer cantidadElementos = 0;
		for(Integer numeroDia = 1; numeroDia <= cantidadDiasPeriodo; numeroDia++) {
			UtilidadValidadorDiasPeriodo.verificarContadorArrDiasElementos(contadorArrayDiasElementos, arrayDiasElementos);
			String strCantidadElementos = arrayDiasElementos[contadorArrayDiasElementos];
			cantidadElementos = UtilidadValidadorDiasPeriodo.obtenerInteger(strCantidadElementos);
			contadorArrayDiasElementos++;
			Dia dia = this.obtenerDia(numeroDia, cantidadElementos);
			List<Elemento> listaElementos = this.obtenerElementosDia(cantidadElementos, arrayDiasElementos);
			Collections.sort(listaElementos);
			dia.setListaElementos(listaElementos);
			listaDias.add(dia);
		}
		return listaDias;
	}
	
	public static FactoriaDiasPeriodo getFactoriaDiasPeriodo() {
		
		if(factoriaDiasPeriodo == null) {
			factoriaDiasPeriodo = new FactoriaDiasPeriodo();
		} 
		
		return factoriaDiasPeriodo;
	}
	
}
