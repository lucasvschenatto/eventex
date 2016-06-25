angular.module("eventex").controller("novoContatoCtrl", function($filter, $scope, $location, contatosAPI, serialGenerator, operadoras){
	$scope.operadoras = operadoras.data;
	$scope.adicionarContato = function(contato){
		contato.serial = serialGenerator.generate();
		contato.data = new Date();
		contato.id = Math.random().toString().substring(2,8);
		contatosAPI.saveContato(contato).success(function(data){
			delete $scope.contato;
			$scope.contatoForm.$setPristine();
			$location.path("/contatos");
		});
	};

} );