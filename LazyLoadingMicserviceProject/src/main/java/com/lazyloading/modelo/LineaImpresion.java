package com.lazyloading.modelo;

public class LineaImpresion implements Comparable<LineaImpresion>{

	private int codigo;
	private String descripcionLinea;
	private Dia dia;
	private int numeroBolsas;
	
	public LineaImpresion() {}
	
	public LineaImpresion(String descripcionLinea, Dia dia) {
		this.descripcionLinea = descripcionLinea;
		this.dia = dia;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcionLinea() {
		descripcionLinea = String.format("Case #%d: %d", dia.getNumeroDia(), numeroBolsas);
		return descripcionLinea;
	}
	public void setDescripcionLinea(String descripcionLinea) {
		this.descripcionLinea = descripcionLinea;
	}
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public int getNumeroBolsas() {
		return numeroBolsas;
	}
	public void setNumeroBolsas(int numeroBolsas) {
		this.numeroBolsas = numeroBolsas;
	}

	@Override
	public String toString() {
		return this.getDescripcionLinea();
	}

	@Override
	public int compareTo(LineaImpresion otraLineaImpresion) {
		int diferencia = this.getDia().compareTo(otraLineaImpresion.getDia());
		return diferencia;
	}
}
