package com.lazyloading.modelo;

public class Elemento implements Comparable<Elemento> {

	private int codigo;
	private String descripcion;
	private String estado;
	
	private Peso peso;
	
	public Elemento() {}
	
	public Elemento(int codigo, String descripcion, String estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Peso getPeso() {
		return peso;
	}
	public void setPeso(Peso peso) {
		this.peso = peso;
	}
	
	public void setPeso(int intPeso, String strUnidadPeso) {
		UnidadPeso unidadPeso = new UnidadPeso();
		unidadPeso.setDescripcion(strUnidadPeso);
		Peso peso = new Peso();
		peso.setValor(intPeso);
		peso.setUnidadPeso(unidadPeso);
		this.setPeso(peso);
	}

	@Override
	public int compareTo(Elemento otroElemento) {
		int diferencia = 1;
		if(otroElemento.getPeso() == null) {
			return diferencia;
		} 
		diferencia = peso.compareTo(otroElemento.getPeso());
		return diferencia;
	}
	
	@Override
	public String toString() {
		Integer valorPeso = 0;
		String descripcion = null;
		if(peso != null) {
			descripcion = String.format("[peso = %d]", peso.getValor());
		} else {
			descripcion = String.format("[peso = %d]", valorPeso);
		}
		return descripcion;
	}
	
	
}
