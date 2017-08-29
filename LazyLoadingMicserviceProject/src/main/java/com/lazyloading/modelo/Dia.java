package com.lazyloading.modelo;

import java.util.LinkedList;
import java.util.List;

import com.jcabi.aspects.Loggable;
import com.lazyloading.excepcion.ExcepcionDias;
import com.lazyloading.utilidad.UtilidadValidadorDia;

public class Dia implements Comparable<Dia>{

	private Integer numeroDia;
	private Integer cantidadElementos;
	private List<Elemento> listaElementos;
	private LineaImpresion lineaImpresion;
	
	public Dia() {
		super();
	}
	
	public Dia(int cantidadElementos, List<Elemento> listaElementos) {
		super();
		this.cantidadElementos = cantidadElementos;
		this.listaElementos = listaElementos;
	}

	public Integer getCantidadElementos() {
		return cantidadElementos;
	}
	public void setCantidadElementos(Integer cantidadElementos) {
		this.cantidadElementos = cantidadElementos;
	}
	public List<Elemento> getListaElementos() {
		return listaElementos;
	}
	public void setListaElementos(List<Elemento> listaElementos) {
		this.listaElementos = listaElementos;
	}
	public LineaImpresion getLineaImpresion() {
		return lineaImpresion;
	}
	public void setLineaImpresion(LineaImpresion lineaImpresion) {
		this.lineaImpresion = lineaImpresion;
	}

	public Integer getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}

	@Loggable
	public LineaImpresion verificarElementos() throws ExcepcionDias  {
		int cuenta = 0;
		UtilidadValidadorDia.verificarListaElementos(listaElementos);
		int atras = listaElementos.size() - 1;
		int adelante = 0;
		while(adelante < atras){
			UtilidadValidadorDia.verificarAtrasListaElementos(atras, listaElementos);
			Elemento elemento = listaElementos.get(atras);
			Peso peso = elemento.getPeso();
			int valorPeso = peso.getValor();
			atras--;
			if(valorPeso < 50) {
				adelante += (50 / valorPeso);
			}
			cuenta++;
		}
		lineaImpresion = this.obtenerLineaImpresion(this, cuenta);
		return lineaImpresion;
	}
	
	private LineaImpresion obtenerLineaImpresion(Dia dia, Integer numeroBolsas) {
		LineaImpresion lineaImpresion = new LineaImpresion();
		lineaImpresion.setDia(dia);
		lineaImpresion.setNumeroBolsas(numeroBolsas);
		lineaImpresion.getDescripcionLinea();
		return lineaImpresion;
	}
	
	public void adicionarElemento(Elemento elemento) {
		List<Elemento> listaElementos = this.getListaElementos();
		if(listaElementos == null) {
			listaElementos = new LinkedList<>();
			this.setListaElementos(listaElementos);
		}
		listaElementos.add(elemento);
	}

	@Override
	public int compareTo(Dia otroDia) {
		if(otroDia == null) {
			return 1;
		} else if(this.getNumeroDia() == otroDia.getNumeroDia()) {
			return 0;
		} else if(this.getNumeroDia() > otroDia.getNumeroDia()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		String descripcion = 
				String.format("[numeroDia = %d, cantidadElementos = %d]", numeroDia, cantidadElementos);
		return descripcion;
	}
}
