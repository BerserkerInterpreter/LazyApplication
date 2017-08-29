package com.lazyloading.test.utilidad;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.TypeAdapter;
import com.lazyloading.excepcion.ExcepcionConvertirListaJSON;
import com.lazyloading.json.adaptador.AdaptadorJSON;
import com.lazyloading.modelo.Elemento;
import com.lazyloading.utilidad.UtilidadConversion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilidadConversionTest {

	@Test(expected = ExcepcionConvertirListaJSON.class)
	public void testConvertirListaJSONNull() {
		Set<Elemento> listaElementos = null;
		UtilidadConversion.convertirListaJSON(listaElementos);
	}
	
	@Test
	public void testConvertirListaJSONConElementoExitoso() {
		Set<Elemento> listaElementos = new TreeSet<>();
		Elemento elemento = this.crearElemento(20, "ACTIVO");
		listaElementos.add(elemento);
		System.out.println("La lista de elementos es: "+ listaElementos);
		String listaElementosJSON = UtilidadConversion.convertirListaJSON(listaElementos);
		Assert.assertNotEquals("TEST: El string de la lista JSON retornada esta vacio.", "", listaElementosJSON);
	}
	
	@Test
	public void testConvertirListaJSONSinElementoExitoso() {
		Set<Elemento> listaElementos = new TreeSet<>();
		String listaElementosJSON = UtilidadConversion.convertirListaJSON(listaElementos);
		Assert.assertNotEquals("TEST: El string de la lista JSON retornada esta vacio.", "", listaElementosJSON);
	}
	
	@Test(expected = ExcepcionConvertirListaJSON.class)
	public void testConvListaJSONNull() {
		Set<Elemento> listaElementos = null;
		Class<?> claseElemento = null;
		TypeAdapter<?> adaptadorJSON = null;
		UtilidadConversion.convertirListaJSON(listaElementos, claseElemento, adaptadorJSON);
	}
	
	@Test(expected = ExcepcionConvertirListaJSON.class)
	public void testConvClaseElementoNull() {
		Set<Elemento> listaElementos = new HashSet<>();
		Class<?> claseElemento = null;
		TypeAdapter<?> adaptadorJSON = null;
		UtilidadConversion.convertirListaJSON(listaElementos, claseElemento, adaptadorJSON);
	}
	
	@Test(expected = ExcepcionConvertirListaJSON.class)
	public void testConvAdaptadorNull() {
		Set<Elemento> listaElementos = new HashSet<>();
		Class<?> claseElemento = Elemento.class;
		TypeAdapter<?> adaptadorJSON = null;
		UtilidadConversion.convertirListaJSON(listaElementos, claseElemento, adaptadorJSON);
	}
	
	@Test
	public void testConvListaJSONConElemExitoso() {
		Set<Elemento> listaElementos = new TreeSet<>();
		Elemento elemento = this.crearElemento(20, "ACTIVO");
		listaElementos.add(elemento);
		Class<?> claseElemento = Elemento.class;
		TypeAdapter<?> adaptadorJSON = new AdaptadorJSON<Elemento>();
		String listaElementosJSON = 
				UtilidadConversion.convertirListaJSON(listaElementos, claseElemento, adaptadorJSON);
		Assert.assertNotEquals("TEST: El string de la lista JSON retornada esta vacio.", "", listaElementosJSON);
	}
	
	@Test
	public void testConvListaJSONSinElemExitoso() {
		Set<Elemento> listaElementos = new TreeSet<>();
		Class<?> claseElemento = Elemento.class;
		TypeAdapter<?> adaptadorJSON = new AdaptadorJSON<Elemento>();
		String listaElementosJSON = 
				UtilidadConversion.convertirListaJSON(listaElementos, claseElemento, adaptadorJSON);
		Assert.assertNotEquals("TEST: El string de la lista JSON retornada esta vacio.", "", listaElementosJSON);
	}
	
	private Elemento crearElemento(Integer codigo, String estado) {
		Elemento elemento = new Elemento();
		elemento.setCodigo(codigo);
		elemento.setEstado(estado);
		return elemento;
	}
	
}
