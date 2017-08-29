package com.lazyloading.modelo;

public class Peso implements Comparable<Peso> {

	private int valor;
	private UnidadPeso unidadPeso;
	
	public Peso() {}
	
	public Peso(int valor, UnidadPeso unidadPeso) {
		super();
		this.valor = valor;
		this.unidadPeso = unidadPeso;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public UnidadPeso getUnidadPeso() {
		return unidadPeso;
	}
	public void setUnidadPeso(UnidadPeso unidadPeso) {
		this.unidadPeso = unidadPeso;
	}

	@Override
	public int compareTo(Peso otroPeso) {
		if(otroPeso == null) {
			return 1;
		} if(this.getValor() == otroPeso.getValor()) {
			return 0;
		} else if(this.getValor() > otroPeso.getValor()) {
			return 1;
		} else {
			return -1;
		}
	}
}
