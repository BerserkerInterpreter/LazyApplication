package com.lazyloading.fachada;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lazyloading.controlador.ControladorNumMaxViajes;

@RestController
@RequestMapping("/api")
public class FachadaLazyLoading {
	
	@RequestMapping(method = RequestMethod.GET, value = "/obtenerMaximoNumeroViajes",
			produces = "application/json")
	public ResponseEntity<String> obtenerMaximoNumeroViajes(String diasElementos) {
		ControladorNumMaxViajes controladorNumMaxViajes =
				ControladorNumMaxViajes.getControladorNumMaxViajes();
		String listaLineaImpresionJSON = controladorNumMaxViajes.determinarMaxNumViajes(diasElementos);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<String> responseEntity =
				new ResponseEntity<>(listaLineaImpresionJSON, responseHeaders, HttpStatus.ACCEPTED);
		return responseEntity;
	}
}
