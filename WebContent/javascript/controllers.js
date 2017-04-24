/**
 * 
 */

var moduloControladores = angular.module('moduloControladores', ['moduloDirectivas','moduloServicios','ui.router']);

moduloControladores.controller('ControladorPrincipal', 
		['$scope','ServicioProcesadorArchivo','$state', 
			function($scope,ServicioProcesadorArchivo,$state) {
	
	$scope.ejecucion = {};
	$scope.contenido = {};
	
	$scope.showContent = function($fileContent){
		console.log('Entro');
        $scope.content = $fileContent;
        console.log($scope.content);
    };
    
    $scope.ejecutarArchivo = function() {
    	var fechaActual = new Date();
    	console.log('Cedula: '+ $scope.ejecucion.cedula);
    	console.log('Fecha actual: '+ fechaActual);
    	console.log('El contenido es: '+ $scope.content);
    	ServicioProcesadorArchivo.procesarArchivo($scope.ejecucion.cedula, fechaActual, $scope.content);
    	console.log('Se ha ejecutado el metodo ServicioProcesadorArchivo.procesarArchivo()');
    	$state.go('ejecucionArchivo');
    };
    
}]);


moduloControladores.controller('ControladorEjecucionArchivo', 
		['$scope','ServicioEjecucionesArchivo', 
	function($scope,ServicioEjecucionesArchivo) {
	
		$scope.ejecucionesArchivo = ServicioEjecucionesArchivo.getListaEjecuciones();
		
		$scope.getEjecucionesArchivo = function() {
			return $scope.ejecucionesArchivo;
		};
	
}]);
