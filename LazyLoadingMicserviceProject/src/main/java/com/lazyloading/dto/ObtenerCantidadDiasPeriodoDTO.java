package com.lazyloading.dto;

public class ObtenerCantidadDiasPeriodoDTO {

	private ContadorArrayDiasElementosDTO contadorArrayDiasElementosDTO;
	private String[] arrayDiasElementos;
	
	public ObtenerCantidadDiasPeriodoDTO() {
		super();
	}

	public ObtenerCantidadDiasPeriodoDTO(ContadorArrayDiasElementosDTO contadorArrayDiasElementosDTO,
			String[] arrayDiasElementos) {
		super();
		this.contadorArrayDiasElementosDTO = contadorArrayDiasElementosDTO;
		this.arrayDiasElementos = arrayDiasElementos;
	}

	public ContadorArrayDiasElementosDTO getContadorArrayDiasElementosDTO() {
		return contadorArrayDiasElementosDTO;
	}

	public void setContadorArrayDiasElementosDTO(ContadorArrayDiasElementosDTO contadorArrayDiasElementosDTO) {
		this.contadorArrayDiasElementosDTO = contadorArrayDiasElementosDTO;
	}

	public String[] getArrayDiasElementos() {
		return arrayDiasElementos;
	}

	public void setArrayDiasElementos(String[] arrayDiasElementos) {
		this.arrayDiasElementos = arrayDiasElementos;
	}

}
