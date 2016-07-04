angular.module("eventex").controller("registerCtrl", function($scope, uiInputAPI, usersAPI, participantsAPI, $location){
	var userCreated;
	$scope.status = {};
	$scope.user = {};
	$scope.participant = {};
	var _help = {};
	var _ph = {};
    var makeField = uiInputAPI.makeField;
	
	_help.username = 'nome para login inválido, use apenas letras e números'
	_help.cpf = 'CPF inválido, use o seguinte formato: 000000000-00';
    _help.email = 'E-mail inválido, por favor use o seguinte formato: exemplo@dominio.com';
    _help.password = 'Senha inválida, ela deve conter no mínimo 8 catacteres, com pelo menos uma letra maiúscula, uma letra minúscula e um número';
    _help.passwordC = 'Confirmação de senha inválida, ela deve ser igual à senha';

	_ph.username = "Digite um nome de usuário que será único no Eventex";
    _ph.email = "E-mail";
	_ph.cpf = "CPF";
    _ph.password = "Digite uma senha";
    _ph.passwordC = "Repita a mesma senha";

    _help.name = '';
	_help.nametag = '';
	_help.nationality = '';
	_help.gender = '';
	_help.education = '';
	_help.birth = '';
	_help.homeAddress = '';
	_help.homePhone = '';
	_help.cellPhone = '';
	_help.professionId = '';
	_help.organization = '';
	_help.department = '';
	_help.role = '';
	_help.workAddress = '';
	_help.workPhone = '';
	_help.workCellphone = '';
	_help.workEmail = '';

	_ph.name = "Nome e Sobrenome";
	_ph.nametag = "Nome para impressão em crachá";
	_ph.nationality = "Nacionalidade";
	_ph.gender = "Sexo";
	_ph.education = "Escolaridade";
	_ph.birth = "Data de nascimento";
	_ph.homeAddress = "Endereço";
	_ph.homePhone = "Telefone";
	_ph.cellPhone = "Celular";
	_ph.professionId = "Profissão";
	_ph.organization = "Empresa";
	_ph.department = "Departamento na empresa";
	_ph.role = "Cargo";
	_ph.workAddress = "Endereço de trabalho";
	_ph.workPhone = "Telefone de trabalho";
	_ph.workCellphone = "Celular de trabalho";
	_ph.workEmail = "Email de trabalho";    


    $scope.message = {userForm:'criando conta',participantForm:'criando perfil'};

    $scope.username = 			  makeField(true, userCreated, _help.username,  "Nome de usuário", _ph.username, "text"    );
	$scope.email = 	  			  makeField(true, userCreated, _help.email,     "E-mail",          _ph.email,    "text"    );
	$scope.cpf =      			  makeField(true, userCreated, _help.cpf,       "CPF",             _ph.cpf,      "text"    );
	$scope.password = 			  makeField(true, userCreated, _help.password,  "Senha",           _ph.password, "password");
	$scope.passwordConfirmation = makeField(true, userCreated, _help.passwordC, "Confirme a senha",_ph.passwordC,"password");

	$scope.name =          makeField(true, !userCreated, _help.name,          "Nome",                    _ph.name,          "text");
	$scope.nametag =       makeField(true, !userCreated, _help.nametag,       "Etiqueta",                _ph.nametag,       "text");
	$scope.nationality =   makeField(true, !userCreated, _help.nationality,   "Nacionalidade",           _ph.nationality,   "text");
	$scope.gender =        makeField(true, !userCreated, _help.gender,        "Sexo",                    _ph.gender,        "text");
	$scope.education =     makeField(true, !userCreated, _help.education,     "Escolaridade",            _ph.education,     "text");
	$scope.birth =         makeField(true, !userCreated, _help.birth,         "Data de nascimento",      _ph.birth,         "text");
	$scope.homeAddress =   makeField(true, !userCreated, _help.homeAddress,   "Endereço",                _ph.homeAddress,   "text");
	$scope.homePhone =     makeField(true, !userCreated, _help.homePhone,     "Telefone",                _ph.homePhone,     "text");
	$scope.cellPhone =     makeField(true, !userCreated, _help.cellPhone,     "Celular",                 _ph.cellPhone,     "text");
	$scope.professionId =  makeField(true, !userCreated, _help.professionId,  "Profissão",               _ph.professionId,  "text");
	$scope.organization =  makeField(true, !userCreated, _help.organization,  "Empresa",                 _ph.organization,  "text");
	$scope.department =    makeField(true, !userCreated, _help.department,    "Departamento na empresa", _ph.department,    "text");
	$scope.role =          makeField(true, !userCreated, _help.role,          "Cargo",                   _ph.role,          "text");
	$scope.workAddress =   makeField(true, !userCreated, _help.workAddress,   "Endereço de trabalho",    _ph.workAddress,   "text");
	$scope.workPhone =     makeField(true, !userCreated, _help.workPhone,     "Telefone de trabalho",    _ph.workPhone,     "text");
	$scope.workCellphone = makeField(true, !userCreated, _help.workCellphone, "Celular de trabalho",     _ph.workCellphone, "text");
	$scope.workEmail =     makeField(true, !userCreated, _help.workEmail,     "Email de trabalho",       _ph.workEmail,     "text");

	var _setUserNoErrors = function(){
		$scope.status.username = '';
		$scope.status.cpf = '';
		$scope.status.email = '';
        $scope.status.password = '';
        $scope.status.passwordConfirmation = '';
	};
	var _setUserErrors = function(status){
		$scope.status.username             = status.invalidUsername ? 'has-error' : '';
		$scope.status.cpf                  = status.invalidCPF ? 'has-error' : '';
		$scope.status.email                = status.invalidEmail ? 'has-error' : '';
        $scope.status.password             = status.invalidPassword ? 'has-error' : '';
        $scope.status.passwordConfirmation = status.invalidPasswordConfirmation ? 'has-error' : '';
	};
	$scope.createUser = function(user){
		usersAPI.createUser(user).then(function(response){
			console.log(response.data);
			if(response.data.success){
				userCreated = true;
				_setUserNoErrors();
			}else
				_setUserErrors(response.data);
            $scope.user.password = "";                
            $scope.user.passwordConfirmation = "";
		});
	};

	$scope.createParticipant = function(participant){
		participantsAPI.createParticipant(participant);
	}
});