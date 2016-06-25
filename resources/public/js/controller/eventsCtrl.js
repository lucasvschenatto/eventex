angular.module("eventex").controller("eventsCtrl", function($scope, eventsAPI, events){
	$scope.app = "Eventex";
	$scope.events = events.data;

	/*var init = function(){
		calcularImpostos($scope.contatos);
		generateSerial($scope.contatos);
	};
	var calcularImpostos = function(contatos){
		contatos.forEach(function(contato){
			contato.operadora.precoComImposto = calcularImposto(contato.operadora.preco);
		});
	};

	var generateSerial = function(contatos){
		contatos.forEach(function(contato){
			contato.serial = contato.serial? contato.serial : serialGenerator.generate();
		});
	};

	$scope.apagarContatos = function(contatos){
		// $scope.contatos = contatos.filter(function(contato){
		// 	if(!contato.selecionado)
		// 		return contato;
		// });
		contatos.forEach(function(contato){
			if(contato.selecionado)
				contatosAPI.deleteContato(contato);
		});
		$scope.isContatoSelecionado(contatos);
	};
	var count = 0;
	$scope.isContatoSelecionado = function(contatos){
		console.log(++count);
		$scope.hasContatoSelecionado = contatos.some(function(contato){
			return contato.selecionado;
		});
	};
	$scope.ordenarPor = function(campo){
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
	var calcularImposto = function(base){
		var imposto = 1.2;
		return base * imposto;
	};
	init();*/
} );