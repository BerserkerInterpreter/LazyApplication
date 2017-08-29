package com.lazyloading.modelo;

import java.util.Set;
import java.util.TreeSet;

import com.jcabi.aspects.Loggable;
import com.lazyloading.excepcion.ExcepcionDias;

public class DiasPeriodo {

	private Integer numeroDias;
	private Set<Dia> listaDias;
	
	public DiasPeriodo() {}
	
	public DiasPeriodo(Integer numeroDias, Set<Dia> listaDias) {
		super();
		this.numeroDias = numeroDias;
		this.listaDias = listaDias;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}
	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}
	public Set<Dia> getListaDias() {
		return listaDias;
	}
	public void setListaDias(Set<Dia> listaDias) {
		this.listaDias = listaDias;
	}
	
	public void adicionarDia(Dia dia) {
		Set<Dia> listaDias = this.getListaDias();
		if(listaDias == null) {
			listaDias = new TreeSet<>();
		}
		listaDias.add(dia);
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
