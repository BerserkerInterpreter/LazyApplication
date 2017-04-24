/**
 * 
 */

var moduloAplicacion = angular.module('moduloAplicacion', 
			['ui.router', 'moduloControladores']);

moduloAplicacion.config(function($stateProvider, $urlRouterProvider) {
	
	$stateProvider.state('formularioArchivo', {
		name: 'formularioArchivo',
		url: '/formularioArchivo',
		templateUrl: '../htmlfiles/formulario_archivo.html'
	});
	
	$stateProvider.state('ejecucionArchivo', {
		name: 'ejecucionArchivo',
		url: '/ejecucionArchivo',
		templateUrl: '../htmlfiles/ejecucion_archivo.html',
	});
	
	$urlRouterProvider.otherwise('/formularioArchivo');
	
});
