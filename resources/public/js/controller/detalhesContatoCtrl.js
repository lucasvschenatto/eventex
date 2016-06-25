angular.module("eventex").controller("detalhesContatoCtrl", function($routeParams, $scope, contato){
		$scope.contato = contato.data;
} );