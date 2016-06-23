angular.module("listaTelefonica").controller("detalhesContatoCtrl", function($routeParams, $scope, contato){
		$scope.contato = contato.data;
} );