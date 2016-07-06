var _registerScopeFields = function(scope, uiInputAPI, editMode){
	scope.username   			= uiInputAPI.makeField(true , editMode , _help.username  , _label.username  , _ph.username  , "text"    );
    scope.email   	  			= uiInputAPI.makeField(true , editMode , _help.email     , _label.email     , _ph.email     , "text"    );
    scope.cpf        			= uiInputAPI.makeField(true , editMode , _help.cpf       , _label.cpf       , _ph.cpf       , "text"    );
    scope.password   			= uiInputAPI.makeField(true , editMode , _help.password  , _label.password  , _ph.password  , "password");
    scope.passwordConfirmation  = uiInputAPI.makeField(true , editMode , _help.passwordC , _label.passwordC , _ph.passwordC , "password");
    
	scope.name          = uiInputAPI.makeField(true, editMode , _help.name          , _label.name         , _ph.name          , "text");
	scope.nametag       = uiInputAPI.makeField(true, editMode , _help.nametag       , _label.nametag      , _ph.nametag       , "text");
	scope.nationality   = uiInputAPI.makeField(true, editMode , _help.nationality   , _label.nationality  , _ph.nationality   , "text");
	scope.gender        = uiInputAPI.makeField(true, editMode , _help.gender        , _label.gender       , _ph.gender        , "text");
	scope.education     = uiInputAPI.makeField(true, editMode , _help.education     , _label.education    , _ph.education     , "text");
	scope.birth         = uiInputAPI.makeField(true, editMode , _help.birth         , _label.birth        , _ph.birth         , "text");
	scope.homeAddress   = uiInputAPI.makeField(true, editMode , _help.homeAddress   , _label.homeAddress  , _ph.homeAddress   , "text");
	scope.homePhone     = uiInputAPI.makeField(true, editMode , _help.homePhone     , _label.homePhone    , _ph.homePhone     , "text");
	scope.cellPhone     = uiInputAPI.makeField(true, editMode , _help.cellPhone     , _label.cellPhone    , _ph.cellPhone     , "text");
	scope.professionId  = uiInputAPI.makeField(true, editMode , _help.professionId  , _label.professionId , _ph.professionId  , "text");
	scope.organization  = uiInputAPI.makeField(true, editMode , _help.organization  , _label.organization , _ph.organization  , "text");
	scope.department    = uiInputAPI.makeField(true, editMode , _help.department    , _label.department   , _ph.department    , "text");
	scope.role          = uiInputAPI.makeField(true, editMode , _help.role          , _label.role         , _ph.role          , "text");
	scope.workAddress   = uiInputAPI.makeField(true, editMode , _help.workAddress   , _label.workAddress  , _ph.workAddress   , "text");
	scope.workPhone     = uiInputAPI.makeField(true, editMode , _help.workPhone     , _label.workPhone    , _ph.workPhone     , "text");
	scope.workCellphone = uiInputAPI.makeField(true, editMode , _help.workCellphone , _label.workCellphon , _ph.workCellphone , "text");
	scope.workEmail     = uiInputAPI.makeField(true, editMode , _help.workEmail     , _label.workEmail    , _ph.workEmail     , "text");
};
var _setRegisterErrors = function(scope, status){
	scope.status                      = {};
	scope.status.name                  = status.invalidName                  ? "has-error" : "";
	scope.status.description           = status.invalidDescription           ? "has-error" : "";
	scope.status.discount              = status.invalidDiscount              ? "has-error" : "";
	scope.status.needCodeAtInscription = status.invalidNeedCodeAtInscription ? "has-error" : "";
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



angular.module("eventex").controller("registerCtrl", function($scope, uiInputAPI, usersAPI, participantsAPI, $location){
	var userCreated;
	$scope.status = {};
	$scope.user = {};
	$scope.participant = {};
    $scope.message = {userForm:'criando conta',participantForm:'criando perfil'};

    _registerScopeFields($scope, uiInputAPI, true);
	
	$scope.createUser = function(user){
		usersAPI.createUser(user).then(function(response){
			console.log(response.data);
			if(response.data.success){
				userCreated = true;
				_setUserNoErrors($scope);
			}else
				_setUserErrors($scope, response.data);
            $scope.user.password = "";                
            $scope.user.passwordConfirmation = "";
		});
	};

	$scope.createParticipant = function(participant){
		participantsAPI.createParticipant(participant);
	}
});