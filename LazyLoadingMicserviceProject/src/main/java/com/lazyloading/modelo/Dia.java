package com.lazyloading.modelo;

import java.util.List;

import com.jcabi.aspects.Loggable;
import com.lazyloading.excepciones.ExcepcionDias;
import com.lazyloading.utilidades.UtilidadValidadorDia;

public class Dia implements Comparable<Dia>{

	private int numeroDiaFisico;
	private List<Elemento> listaElementos;
	private LineaImpresion lineaImpresion;
	
	private int numeroDia;
	
	public Dia() {}
	
	public Dia(int numero, List<Elemento> listaElementos) {
		super();
		this.numeroDiaFisico = numero;
		this.listaElementos = listaElementos;
	}

	public int getNumeroFisico() {
		return numeroDiaFisico;
	}
	public void setNumeroFisico(int numeroFisico) {
		this.numeroDiaFisico = numeroFisico;
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

	public int getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(int numeroDia) {
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
		
		LineaImpresion lineaImpresion = new LineaImpresion();
		lineaImpresion.setDia(this);
		lineaImpresion.setNumeroBolsas(cuenta);
		lineaImpresion.getDescripcionLinea();
		
		return lineaImpresion;
		
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
		String descripcion = String.format("[numeroDia = %d]", numeroDia);
		return descripcion;
	}
}
