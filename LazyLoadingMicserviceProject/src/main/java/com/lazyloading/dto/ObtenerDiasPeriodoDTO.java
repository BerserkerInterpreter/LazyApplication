package com.lazyloading.dto;

public class ObtenerDiasPeriodoDTO {
	
	private Integer cantidadDiasPeriodo;
	private Integer contadorArrayDiasElementos;
	private String[] arrayDiasElementos;
	
	public ObtenerDiasPeriodoDTO() {
		super();
	}
	
	public ObtenerDiasPeriodoDTO(Integer cantidadDiasPeriodo, Integer contadorArrayDiasElementos,
			String[] arrayDiasElementos) {
		super();
		this.cantidadDiasPeriodo = cantidadDiasPeriodo;
		this.contadorArrayDiasElementos = contadorArrayDiasElementos;
		this.arrayDiasElementos = arrayDiasElementos;
	}

	public Integer getCantidadDiasPeriodo() {
		return cantidadDiasPeriodo;
	}

	public void setCantidadDiasPeriodo(Integer cantidadDiasPeriodo) {
		this.cantidadDiasPeriodo = cantidadDiasPeriodo;
	}

	public Integer getContadorArrayDiasElementos() {
		return contadorArrayDiasElementos;
	}

	public void setContadorArrayDiasElementos(Integer contadorArrayDiasElementos) {
		this.contadorArrayDiasElementos = contadorArrayDiasElementos;
	}

	public String[] getArrayDiasElementos() {
		return arrayDiasElementos;
	}

	public void setArrayDiasElementos(String[] arrayDiasElementos) {
		this.arrayDiasElementos = arrayDiasElementos;
	}
	
}
