package com.lazyloading.modelo;

import java.util.Set;
import java.util.TreeSet;

import com.jcabi.aspects.Loggable;
import com.lazyloading.excepciones.ExcepcionDias;

public class DiasPeriodo {

	private int numeroDias;
	private Set<Dia> listaDias;
	
	public DiasPeriodo() {}
	
	public DiasPeriodo(int numeroDias, Set<Dia> listaDias) {
		super();
		this.numeroDias = numeroDias;
		this.listaDias = listaDias;
	}

	public int getNumeroDias() {
		return numeroDias;
	}
	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}
	public Set<Dia> getListaDias() {
		return listaDias;
	}
	public void setListaDias(Set<Dia> listaDias) {
		this.listaDias = listaDias;
	}
	
	@Loggable(Loggable.INFO)
	public Set<LineaImpresion> verificarDias() throws ExcepcionDias {
		
		Set<LineaImpresion> listaLineaImpresion 
				= new TreeSet<>();
		
		for(Dia dia : listaDias) {	
			LineaImpresion lineaImpresion = dia.verificarElementos();
			listaLineaImpresion.add(lineaImpresion);
		}
		
		return listaLineaImpresion;
		
	}
}
