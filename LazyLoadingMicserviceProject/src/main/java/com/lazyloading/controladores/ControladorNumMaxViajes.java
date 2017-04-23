package com.lazyloading.controladores;

import java.util.Set;

import com.jcabi.aspects.Loggable;
import com.lazyloading.excepciones.ExcepcionDias;
import com.lazyloading.excepciones.ExcepcionDiasPeriodo;
import com.lazyloading.factorias.FactoriaDiasPeriodo;
import com.lazyloading.modelo.DiasPeriodo;
import com.lazyloading.modelo.LineaImpresion;
import com.lazyloading.utilidades.UtilidadConversion;
import com.lazyloading.utilidades.UtilidadRespuestaPorDefecto;

public class ControladorNumMaxViajes {

	public ControladorNumMaxViajes() {}
	
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
			listaLineaImpresion = UtilidadRespuestaPorDefecto.obtenertLineaImpresion();
		} catch(ExcepcionDias ed) {
			ed.printStackTrace();
			listaLineaImpresion = UtilidadRespuestaPorDefecto.obtenertLineaImpresion();
		} catch(Exception ex) {
			ex.printStackTrace();
			listaLineaImpresion = UtilidadRespuestaPorDefecto.obtenertLineaImpresion();
		}
		
		String listaLineaImpresionJSON = UtilidadConversion.convertirListaJSON(listaLineaImpresion);
		
		return listaLineaImpresionJSON;
		
	}
	
}
