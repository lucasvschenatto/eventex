var _registerScopeFields = function(scope, uiInputAPI, editMode){
	scope.username   			= uiInputAPI.makeField(true , editMode , _help.username  , _label.username  , _ph.username  , "text"    );
    scope.email   	  			= uiInputAPI.makeField(true , editMode , _help.email     , _label.email     , _ph.email     , "text"    );
    scope.cpf        			= uiInputAPI.makeField(true , editMode , _help.cpf       , _label.cpf       , _ph.cpf       , "text"    );
    scope.password   			= uiInputAPI.makeField(true , editMode , _help.password  , _label.password  , _ph.password  , "password");
    scope.passwordConfirmation  = uiInputAPI.makeField(true , editMode , _help.passwordC , _label.passwordC , _ph.passwordC , "password");
    
	scope.name                  = uiInputAPI.makeField(true  ,editMode ,_help.name          ,_label.name          , _ph.name          ,"text");
	scope.nametag               = uiInputAPI.makeField(true  ,editMode ,_help.nametag       ,_label.nametag       , _ph.nametag       ,"text");
	scope.nationality           = uiInputAPI.makeField(true  ,editMode ,_help.nationality   ,_label.nationality   , _ph.nationality   ,"text");
	scope.gender                = uiInputAPI.makeField(true  ,editMode ,_help.gender        ,_label.gender        , _ph.gender        ,"text");
	scope.education             = uiInputAPI.makeField(true  ,editMode ,_help.education     ,_label.education     , _ph.education     ,"text");
	scope.birth                 = uiInputAPI.makeField(true  ,editMode ,_help.date          ,_label.birth         , _ph.birth         ,"text");
	scope.address               = {};
	scope.address.street        = uiInputAPI.makeField(true , editMode, _help.street        , _label.street       , _ph.street        ,"text");
	scope.address.number        = uiInputAPI.makeField(true , editMode, _help.number        , _label.number       , _ph.number        ,"text");
	scope.address.complement    = uiInputAPI.makeField(true , editMode, _help.complement    , _label.complement   , _ph.complement    ,"text");
	scope.address.neighborhood  = uiInputAPI.makeField(true , editMode, _help.neighborhood  , _label.neighborhood , _ph.neighborhood  ,"text");
	scope.address.city          = uiInputAPI.makeField(true , editMode, _help.city          , _label.city         , _ph.city          ,"text");
	scope.address.state         = uiInputAPI.makeField(true , editMode, _help.state         , _label.state        , _ph.state         ,"text");
	scope.address.country       = uiInputAPI.makeField(true , editMode, _help.country       , _label.country      , _ph.country       ,"text");
	scope.address.cep           = uiInputAPI.makeField(true , editMode, _help.cep           , _label.cep          , _ph.cep           ,"text");
	scope.cellPhone             = uiInputAPI.makeField(true  ,editMode ,_help.cellPhone     ,_label.cellPhone     , _ph.cellPhone     ,"text");
	scope.phone                 = uiInputAPI.makeField(true  ,editMode ,_help.phone         ,_label.phone         , _ph.phone         ,"text");
	scope.profession            = uiInputAPI.makeField(true  ,editMode ,_help.profession    ,_label.profession    , _ph.profession    ,"text");
	scope.organization          = uiInputAPI.makeField(true  ,editMode ,_help.organization  ,_label.organization  , _ph.organization  ,"text");
	scope.department            = uiInputAPI.makeField(true  ,editMode ,_help.department    ,_label.department    , _ph.department    ,"text");
	scope.role                  = uiInputAPI.makeField(true  ,editMode ,_help.role          ,_label.role          , _ph.role          ,"text");
	scope.email                 = uiInputAPI.makeField(true  ,editMode ,_help.email         ,_label.email         , _ph.email         ,"text");
};
var _setParticipantErrors = function(scope, status){
	scope.status.name                     = status.invalidName                     ? "has-error" : "";
	scope.status.user                     = status.invalidUserId                   ? "has-error" : "";
	scope.status.nametag                  = status.invalidNametag                  ? "has-error" : "";
	scope.status.nationality              = status.invalidNationality              ? "has-error" : "";
	scope.status.gender                   = status.invalidGender                   ? "has-error" : "";
	scope.status.education                = status.invalidEducation                ? "has-error" : "";
	scope.status.birth                    = status.invalidBirth                    ? "has-error" : "";
	scope.status.homeAddress              = {};
	scope.status.homeAddress.street       = status.homeAddress.invalidStreet       ? "has-error" : "";
	scope.status.homeAddress.number       = status.homeAddress.invalidNumber       ? "has-error" : "";
	scope.status.homeAddress.complement   = status.homeAddress.invalidComplement   ? "has-error" : "";
	scope.status.homeAddress.neighborhood = status.homeAddress.invalidNeighborhood ? "has-error" : "";
	scope.status.homeAddress.city         = status.homeAddress.invalidCity         ? "has-error" : "";
	scope.status.homeAddress.state        = status.homeAddress.invalidState        ? "has-error" : "";
	scope.status.homeAddress.country      = status.homeAddress.invalidCountry      ? "has-error" : "";
	scope.status.homeAddress.cep          = status.homeAddress.invalidCEP          ? "has-error" : "";
	scope.status.homePhone                = status.invalidHomePhone                ? "has-error" : "";
	scope.status.cellphone                = status.invalidCellPhone                ? "has-error" : "";
	scope.status.profession               = status.invalidProfessionId             ? "has-error" : "";
	scope.status.organization             = status.invalidOrganization             ? "has-error" : "";
	scope.status.department               = status.invalidDepartment               ? "has-error" : "";
	scope.status.role                     = status.invalidRole                     ? "has-error" : "";
	scope.status.workAddress              = {};
	scope.status.workAddress.street       = status.workAddress.invalidStreet       ? "has-error" : "";
	scope.status.workAddress.number       = status.workAddress.invalidNumber       ? "has-error" : "";
	scope.status.workAddress.complement   = status.workAddress.invalidComplement   ? "has-error" : "";
	scope.status.workAddress.neighborhood = status.workAddress.invalidNeighborhood ? "has-error" : "";
	scope.status.workAddress.city         = status.workAddress.invalidCity         ? "has-error" : "";
	scope.status.workAddress.state        = status.workAddress.invalidState        ? "has-error" : "";
	scope.status.workAddress.country      = status.workAddress.invalidCountry      ? "has-error" : "";
	scope.status.workAddress.cep          = status.workAddress.invalidCEP          ? "has-error" : "";
	scope.status.workPhone                = status.invalidWorkPhone                ? "has-error" : "";
	scope.status.workCellphone            = status.invalidWorkCellphone            ? "has-error" : "";
	scope.status.workEmail                = status.invalidWorkEmail                ? "has-error" : "";
};
var _setUserNoErrors = function(scope){
	scope.status.username = '';
	scope.status.cpf = '';
	scope.status.email = '';
	scope.status.password = '';
	scope.status.passwordConfirmation = '';
};
var _setUserErrors = function(scope, status){
	scope.status.username             = status.invalidUsername ? 'has-error' : '';
	scope.status.cpf                  = status.invalidCPF ? 'has-error' : '';
	scope.status.email                = status.invalidEmail ? 'has-error' : '';
	scope.status.password             = status.invalidPassword ? 'has-error' : '';
	scope.status.passwordConfirmation = status.invalidPasswordConfirmation ? 'has-error' : '';
};



angular.module("eventex").controller("registerCtrl", function($scope, $state, uiInputAPI, usersAPI, participantsAPI, $location){
	$scope.userCreated;
	$scope.status = {};
	$scope.user = {};
	$scope.participant = {};
    $scope.message = {};

    _registerScopeFields($scope, uiInputAPI, true);
	
	$scope.createUser = function(user){
		$scope.message.userForm = 'criando conta';
		usersAPI.create(user).then(function(response){
			$scope.message.userForm = "";
			if(response.data.success){
				$scope.userCreated = true;
				_setUserNoErrors($scope);
			}else
				_setUserErrors($scope, response.data);
            $scope.user.password = "";                
            $scope.user.passwordConfirmation = "";
		});
	};

	$scope.createParticipant = function(participant){
		$scope.message.participantForm = 'criando perfil';
		participantsAPI.create(participant).then(function(response){
			$scope.message.participantForm = "";
			if(response.data.success){
				console.log(response.data);
				$state.go("dashboard");
			}else
				_setParticipantErrors($scope, response.data);
		});
	}
});