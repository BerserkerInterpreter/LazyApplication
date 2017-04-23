package com.lazyloading.fachada;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lazyloading.controladores.ControladorNumMaxViajes;
import com.lazyloading.factorias.FactoriaControladores;

@RestController
@RequestMapping("/api")
public class FachadaLazyLoading {
	
	@RequestMapping(method = RequestMethod.GET, value = "/obtenerMaximoNumeroViajes",
			produces = "application/json")
	public ResponseEntity<String> obtenerMaximoNumeroViajes(String diasElementos) {
		
		FactoriaControladores factoriaControladores =
				FactoriaControladores.getFactoriaControladores();
		ControladorNumMaxViajes controladorNumMaxViajes =
				factoriaControladores.getControladorNumMaxViajes();
		
		String listaLineaImpresionJSON = controladorNumMaxViajes.determinarMaxNumViajes(diasElementos);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		
		ResponseEntity<String> responseEntity =
				new ResponseEntity<>(listaLineaImpresionJSON, responseHeaders, HttpStatus.CREATED);
		
		return responseEntity;
		
	}
}
