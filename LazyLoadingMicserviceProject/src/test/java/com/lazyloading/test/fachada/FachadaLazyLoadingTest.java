package com.lazyloading.test.fachada;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.lazyloading.fachada.FachadaLazyLoading;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FachadaLazyLoadingTest {

	@Test
	public void testObtenerMaximoNumeroViajes() {
		String diasElementos = "5,4,30,30,1,1,3,20,20,20,11,1,2,3,4,5,6,7,8,9,10,11,6,9,19,29,39,49,59,10,32,56,76,8,44,60,47,85,71,91";
		FachadaLazyLoading fachadaLazyLoading = 
				new FachadaLazyLoading();
		ResponseEntity<String> responseEntity = fachadaLazyLoading.obtenerMaximoNumeroViajes(diasElementos);
		this.verificarCabecerasHTTP(responseEntity);
		this.verificarBodyHTTP(responseEntity);
		
	}
	
	private void verificarBodyHTTP(ResponseEntity<String> responseEntity) {
		String responseEntityBody = responseEntity.getBody();
		Assert.assertNotNull("TEST: La cabecera de la respuesta HTTP no puede ser igual a null.", responseEntityBody);
		String valorNoEsperado = "";
		Assert.assertNotEquals("TEST: La cabecera de la respuesta HTTP no puede estar vacia.", valorNoEsperado, responseEntityBody);
	}
	
	private void verificarCabecerasHTTP(ResponseEntity<String> responseEntity) {
		HttpHeaders responseEntityHeaders = responseEntity.getHeaders();
		String accessControlHeaderKey = "Access-Control-Allow-Origin";
		List<String> listaHttpHeaders = responseEntityHeaders.get(accessControlHeaderKey);
		String accessControlHeader = listaHttpHeaders.get(0);
		String accessControlHeaderValueDeseado = "*";
		Assert.assertNotNull("TEST: La cabecera \"Access-Control-Allow-Origin\" no puede ser igual a null.", accessControlHeader);
		Assert.assertEquals("TEST: La cabecera \"Access-Control-Allow-Origin\" no tiene el valor deseado \"0\"",
				accessControlHeaderValueDeseado, accessControlHeader);
	}

}
