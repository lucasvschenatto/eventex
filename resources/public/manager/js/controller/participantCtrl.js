var _participantScopeFields = function(scope, uiInputAPI, editMode){
	scope.name                  = uiInputAPI.makeField(true  ,editMode ,_help.name          ,_label.name          , _ph.name          ,"text");
	scope.user                  = uiInputAPI.makeField(true  ,editMode ,_help.user          ,_label.user          , _ph.user          ,"text");
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
	scope.status                          = {};
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
}



angular.module("eventex").controller("participantNewCtrl", function($scope,$modalInstance,uiInputAPI, participantsAPI){
	$scope.entity = {};
	_participantScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(participant){
		participantsAPI.create(participant).then(function(response){
			if(response.data.success)
				$modalInstance.close(true);
			else
				_setParticipantErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );
angular.module("eventex").controller("participantEditCtrl", function($scope,$modalInstance,uiInputAPI, participantsAPI, data){
	$scope.entity = data;
	_participantScopeFields($scope, uiInputAPI, true);

	$scope.delete = function(participant){
		participantsAPI.delete(participant);
		$modalInstance.close('deleted');
	};
	$scope.submit = function(participant){
		participantsAPI.update(participant).then(function(response){
			if(response.data.success)
				participantsAPI.get(participant.id).then(function(response){
					$scope.entity = response.data;
				});
			else
				_setParticipantErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );