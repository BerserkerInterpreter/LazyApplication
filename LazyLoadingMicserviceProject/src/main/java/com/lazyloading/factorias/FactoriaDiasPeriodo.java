package com.lazyloading.factorias;

import com.jcabi.aspects.Loggable;
import com.lazyloading.configuracion.UtilidadConfiguracionSistema;
import com.lazyloading.excepciones.ExcepcionDiasPeriodo;
import com.lazyloading.modelo.Dia;
import com.lazyloading.modelo.DiasPeriodo;
import com.lazyloading.modelo.Elemento;
import com.lazyloading.utilidades.UtilidadValidadorDiasPeriodo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Set;
import java.util.TreeSet;

public class FactoriaDiasPeriodo {

	private static FactoriaDiasPeriodo factoriaDiasPeriodo;
	
	private FactoriaDiasPeriodo() {}
	
	@Loggable(Loggable.INFO)
	public DiasPeriodo getDiasPeriodo(String diasElementos) throws ExcepcionDiasPeriodo {
		
		UtilidadValidadorDiasPeriodo.verificarDiasElementos(diasElementos);
		
		String separador = UtilidadConfiguracionSistema.getSeparador();
		String reemplazo = UtilidadConfiguracionSistema.getReemplazo();
		diasElementos = diasElementos.replace(separador, reemplazo);
		String[] arrayDiasElementos = diasElementos.split(reemplazo);
		
		UtilidadValidadorDiasPeriodo.verificarArrayDiasElementos(arrayDiasElementos);
		
		int contadorArrDiasElementos = 0;
		String strVeces = arrayDiasElementos[contadorArrDiasElementos];
		
		UtilidadValidadorDiasPeriodo.verificarVeces(strVeces);
		
		int veces = UtilidadValidadorDiasPeriodo.obtenerInteger(strVeces);
		
		UtilidadValidadorDiasPeriodo.verificarVeces(veces, arrayDiasElementos);
		
		contadorArrDiasElementos++;

		DiasPeriodo diasPeriodo = new DiasPeriodo();
		diasPeriodo.setNumeroDias(veces);
		
		Set<Dia> listaDias = new TreeSet<>();
		
		int diaFisico = 0;
		int numeroDia = 1;
		for(int i = 1; i <= veces; i++) {
			
			UtilidadValidadorDiasPeriodo.verificarContadorArrDiasElementos(contadorArrDiasElementos, arrayDiasElementos);
			
			String strDiaFisico = arrayDiasElementos[contadorArrDiasElementos];
			
			diaFisico = UtilidadValidadorDiasPeriodo.obtenerInteger(strDiaFisico);
			contadorArrDiasElementos++;
			
			Dia dia = new Dia();
			dia.setNumeroFisico(diaFisico);
			dia.setNumeroDia(numeroDia);
			numeroDia++;
			List<Elemento> listaElementos = 
					new ArrayList<>();
			
			int pesoElemento = 0;
			for(int j = 0; j < diaFisico; j++) {
				
				UtilidadValidadorDiasPeriodo.verificarContadorArrDiasElementos(contadorArrDiasElementos, arrayDiasElementos);
				
				String strPesoElemento = arrayDiasElementos[contadorArrDiasElementos];
				pesoElemento = UtilidadValidadorDiasPeriodo.obtenerInteger(strPesoElemento);
				contadorArrDiasElementos++;
				
				Elemento elemento = new Elemento();
				String unidadPeso = UtilidadConfiguracionSistema.getUnidadPeso();
				elemento.setPeso(pesoElemento, unidadPeso);
				listaElementos.add(elemento);
				
			}
			
			Collections.sort(listaElementos);
			
			dia.setListaElementos(listaElementos);
			listaDias.add(dia);
		}
		
		diasPeriodo.setListaDias(listaDias);
		
		return diasPeriodo;
	}
	
	public static FactoriaDiasPeriodo getFactoriaDiasPeriodo() {
		
		if(factoriaDiasPeriodo == null) {
			factoriaDiasPeriodo = new FactoriaDiasPeriodo();
		} 
		
		return factoriaDiasPeriodo;
	}
	
}
