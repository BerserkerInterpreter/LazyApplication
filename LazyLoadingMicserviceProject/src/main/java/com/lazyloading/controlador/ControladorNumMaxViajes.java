package com.lazyloading.controlador;

import java.util.Set;

import com.jcabi.aspects.Loggable;
import com.lazyloading.excepcion.ExcepcionDias;
import com.lazyloading.excepcion.ExcepcionDiasPeriodo;
import com.lazyloading.factoria.FactoriaDiasPeriodo;
import com.lazyloading.json.adaptador.AdaptadorJSON;
import com.lazyloading.modelo.DiasPeriodo;
import com.lazyloading.modelo.LineaImpresion;
import com.lazyloading.utilidad.UtilidadConversion;
import com.lazyloading.utilidad.UtilidadRespuestaPorDefecto;

public class ControladorNumMaxViajes {

	private static ControladorNumMaxViajes controladorNumMaxViajes;
	
	private ControladorNumMaxViajes() {
		super();
	}
	
	public static ControladorNumMaxViajes getControladorNumMaxViajes() {
		if(controladorNumMaxViajes == null) {
			controladorNumMaxViajes = new ControladorNumMaxViajes();
		}
		return controladorNumMaxViajes;
	}
	
	@Loggable(Loggable.INFO)
	public String determinarMaxNumViajes(String diasElementos) {
		
		FactoriaDiasPeriodo factoriaDiasPeriodo =
				FactoriaDiasPeriodo.getFactoriaDiasPeriodo();
		DiasPeriodo diasPeriodo = null;
		Set<LineaImpresion> listaLineaImpresion = null;
		
		try {
			diasPeriodo = factoriaDiasPeriodo.getDiasPeriodo(diasElementos);
			listaLineaImpresion = diasPeriodo.verificarDias();
		} catch (ExcepcionDiasPeriodo edp) {
			edp.printStackTrace();
			listaLineaImpresion = this.obtenerLineaImpresionDefecto();
		} catch(ExcepcionDias ed) {
			ed.printStackTrace();
			listaLineaImpresion = this.obtenerLineaImpresionDefecto();
		} catch(Exception ex) {
			ex.printStackTrace();
			listaLineaImpresion = this.obtenerLineaImpresionDefecto();
		}
	
		String listaLineaImpresionJSON = this.obtenerListaLineaImpresionJSON(listaLineaImpresion);
		
		return listaLineaImpresionJSON;
		
	}
	
	private String obtenerListaLineaImpresionJSON(
			Set<LineaImpresion> listaLineaImpresion) {
		AdaptadorJSON<LineaImpresion> adaptadorJSON = new AdaptadorJSON<>();
		String listaLineaImpresionJSON = 
				UtilidadConversion.convertirListaJSON(listaLineaImpresion, LineaImpresion.class, adaptadorJSON);
		return listaLineaImpresionJSON;
	}
	
	private Set<LineaImpresion> obtenerLineaImpresionDefecto() {
		Set<LineaImpresion> listaLineaImpresion = UtilidadRespuestaPorDefecto.obtenerLineaImpresion();
		return listaLineaImpresion;
	}
	
}
