/**
 * 
 */

var moduloDirectivas = angular.module('moduloDirectivas', []);

moduloDirectivas.directive('onReadFile', function ($parse) {
	return {
		restrict: 'A',
		scope: false,
		link: function(scope, element, attrs) {
            var fn = $parse(attrs.onReadFile);
            
			element.on('change', function(onChangeEvent) {
				var reader = new FileReader();
                
				reader.onload = function(onLoadEvent) {
					scope.$apply(function() {
						fn(scope, {$fileContent:onLoadEvent.target.result});
					});
				};

				reader.readAsText((onChangeEvent.srcElement || onChangeEvent.target).files[0]);
			});
		}
	};
});

moduloDirectivas.directive('validFile', function(){
	  return {
		    require:'ngModel',
		    link:function(scope,el,attrs,ngModel){
		      //change event is fired when file is selected
		      el.bind('change',function(){
		        scope.$apply(function(){
		          ngModel.$setViewValue(el.val());
		          ngModel.$render();
		        })
		      })
		    }
		  }
		});

moduloDirectivas.directive('validContent', [function() {
		var validContentRegex = /(\d*\n\d*)+/g;
		return {
			restrict: 'A',
			require: 'ngModel',
			link: function($scope, $element, $attrs, ngModelCtrl) {
				
				console.log('Entro a validContent');
				// Manejo de Actualizacion del DOM --> Actualizacion del Modelo
				ngModelCtrl.$parsers.unshift(function(value) {
					var valid = validContentRegex.test(value);
					
					console.log('Actualizacion del DOM al Modelo => '+ valid);
					ngModelCtrl.$setValidity('validContent', valid);
					return valid ? value : undefined;
				});
				// Manejo de Actualizacion del Modelo --> Actualizacion del DOM
				ngModelCtrl.$formatters.unshift(function(value) {
					
					console.log('Actualizacion del Modelo al DOM =>'+ value);
					ngModelCtrl.$setValidity('validContent',
						validContentRegex.test(value));
					return value;
				});
			}
		};
	}]);
