angular.module("eventex").controller("registerCtrl", function($scope, usersAPI, participantsAPI, $location){
	$scope.user = {teste:"!!!!!!!!!!!!!!!!!!!!!!!"};
	$scope.userMessages = {username:"", cpf:"", email:"", password:"", passwordConfirmation:"", user:"", form:""};
	$scope.userStatus   = {username:"", cpf:"", email:"", password:"", passwordConfirmation:"", user:""};

	$scope.createUser = function(user){
		$scope.userMessages.userForm = 'criando conta';
		usersAPI.createUser(user).then(function(response){
			$scope.userMessages.userForm = '';
			console.log(response.data);
			if(response.data.success)
				$scope.userCreated = true;
			else
				$scope.userStatus.username = response.data.invalidUsername ? 'has-error' : '';
				$scope.userStatus.cpf = response.data.invalidCPF ? 'has-error' : '';
				$scope.userStatus.email = response.data.invalidEmail ? 'has-error' : '';
                $scope.userStatus.password = response.data.invalidPassword ? 'has-error' : '';
                $scope.userStatus.passwordConfirmation = response.data.invalidPasswordConfirmation ? 'has-error' : '';

                $scope.userMessages.username = response.data.invalidUsername ? 'nome para login inválido, use apenas letras e números' : '';
				$scope.userMessages.cpf = response.data.invalidCPF ? 'CPF inválido, use o seguinte formato: 000000000-00' : '';
                $scope.userMessages.email = response.data.invalidEmail ? 'E-mail inválido, por favor use o seguinte formato: exemplo@dominio.com' : '';
                $scope.userMessages.password = response.data.invalidPassword ? 'Senha inválida, ela deve conter no mínimo 8 catacteres, com pelo menos uma letra maiúscula, uma letra minúscula e um número' : '';
                $scope.userMessages.passwordConfirmation = response.data.invalidPasswordConfirmation ? 'Confirmação de senha inválida, ela deve ser igual à senha' : '';
		});
	};

	$scope.createParticipant = function(participant){
		participantsAPI.createParticipant(participant);
	}
});