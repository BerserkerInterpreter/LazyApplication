package com.lazyloading.factorias;

import com.lazyloading.controladores.ControladorNumMaxViajes;

public class FactoriaControladores {

	private static FactoriaControladores factoriaControladores;
	
	private ControladorNumMaxViajes controladorNumMaxViajes;
	
	private FactoriaControladores() {}
	
	public ControladorNumMaxViajes getControladorNumMaxViajes() {
		
		if(controladorNumMaxViajes == null) {
			controladorNumMaxViajes = new ControladorNumMaxViajes();
		}
		
		return controladorNumMaxViajes;
		
	}
	
	public static FactoriaControladores getFactoriaControladores() {
		
		if(factoriaControladores == null) {
			factoriaControladores = new FactoriaControladores();
		}
		
		return factoriaControladores;
		
	}
}
