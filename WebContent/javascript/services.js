/**
 * 
 */

var moduloServicios = angular.module('moduloServicios', []);

moduloServicios.service('ServicioMicroservicioLazyLoading', ['$http', 
	function ServicioMicroservicioLazyLoading($http) {
		var self = this;
	
		self.obtenerMaximoNumeroViajes = function(contenido) {
			console.log('Entro a obtenerMaximoNumeroViajes ServicioMicroservicioLazyLoading');
			console.log('El contenido es => '+ contenido);
			var promise = $http.get('http://localhost:8080/api/obtenerMaximoNumeroViajes?diasElementos=' + contenido);
			// var promise = $http.get('http://localhost:8080/api/obtenerMaximoNumeroViajes?diasElementos=5%5Cn4%5Cn30%5Cn30%5Cn1%5Cn1%5Cn3%5Cn20%5Cn20%5Cn20%5Cn11%5Cn1%5Cn2%5Cn3%5Cn4%5Cn5%5Cn6%5Cn7%5Cn8%5Cn9%5Cn10%5Cn11%5Cn6%5Cn9%5Cn19%5Cn29%5Cn39%5Cn49%5Cn59%5Cn10%5Cn32%5Cn56%5Cn76%5Cn8%5Cn44%5Cn60%5Cn47%5Cn85%5Cn71%5Cn91');	
			return promise;
		};
}]);

moduloServicios.service('ServicioEjecucionesArchivo', function ServicioEjecucionesArchivo() {
	
	var self = this;
	
	self.listaEjecuciones = [{
		cedulaKey: '123456789',
		fechaKey: '9/04/1888',
		lineasImpresionKey: [
			{codigo: '50525', descripcionLinea: 'Case #50525: 3', numeroBolsas: 3}
		]
	}];
	
	self.adicionarEjecucion = function(cedula, fecha, lineasImpresion) {
		console.log('Se va a adicionar la ejecucion');
		
		console.log('Cedula: '+ cedula);
		
		var ejecucionArchivo = {
			cedulaKey: cedula,
			fechaKey: fecha,
			lineasImpresionKey: lineasImpresion
		};
		
		self.listaEjecuciones.push(ejecucionArchivo);
		
		console.log('Se adiciono la ejecucion exitosamente');
	};
	
	self.getListaEjecuciones = function() {
		return self.listaEjecuciones;
	}
	
});

moduloServicios.service('ServicioProcesadorArchivo', 
		['ServicioMicroservicioLazyLoading', 'ServicioEjecucionesArchivo', 
			function ServicioProcesadorArchivo(ServicioMicroservicioLazyLoading, ServicioEjecucionesArchivo) {
				var self = this;
			
				console.log('Entro servicio');
			
				self.procesarArchivo = function(cedula, fecha, contenido) {
					
					console.log('Entro en la funcion procesarArchivo');
					
					var contenidoProcesado = self.procesarEspacios(contenido);
					
					var promise = ServicioMicroservicioLazyLoading.obtenerMaximoNumeroViajes(contenidoProcesado);
					
					console.log('Se obtuvo la promesa');
					
					promise.then(function(response) {
						console.log('Entro a la parte buena de la promesa');
						self.lineasImpresion = response.data;
						console.log('La respuesta es => '+ self.lineasImpresion);
						console.log('La cedula es => '+ cedula);
						ServicioEjecucionesArchivo.adicionarEjecucion(cedula, fecha, self.lineasImpresion);
					}, function(errorResponse) {
						console.log('Entro a la parte mala de la promesa');
						var mensajeError = 'ERROR: Ocurrio un error al consultar el servidor.';
						self.lineasImpresion = mensajeError;
						console.error(mensajeError);
					});
					
					console.log('Las lineas de impresion se van a retornar');
					
					return self.lineasImpresion;
					
				};
				
				self.procesarEspacios = function(contenido) {
					var arrayElementos = contenido.split('\n');
					var resultado = '';
					for(i = 0; i<arrayElementos.length; i++) {
						
						if(i == arrayElementos.length - 1) {
							resultado += arrayElementos[i];
							console.log('Entro ultimo elemento: '+ arrayElementos[i]);
						} else {
							resultado += arrayElementos[i] + ',';
							console.log('Entro elemento normal: '+ arrayElementos[i]);
						}
					}
					
					console.log('El resultado fue => '+ resultado);
					
					return resultado;
				};
	}]);
