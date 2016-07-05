var _eventScopeFields = function(scope, uiInputAPI, editMode){
	scope.name                  = uiInputAPI.makeField(true  ,editMode ,_help.name        ,_label.name        ,_ph.name        ,"text");
	scope.description           = uiInputAPI.makeField(false ,editMode ,_help.description ,_label.description ,_ph.description ,"text");
	scope.date                  = uiInputAPI.makeField(true  ,editMode ,_help.date        ,_label.date        ,_ph.date         ,"text");
	scope.time                  = uiInputAPI.makeField(true  ,editMode ,_help.time        ,_label.time        ,_ph.time         ,"text");
	scope.place                 = uiInputAPI.makeField(true  ,editMode ,_help.place       ,_label.place       ,_ph.place        ,"text");
	scope.address               = {};
	scope.address.street        = uiInputAPI.makeField(true , editMode, _help.street        , _label.street       , _ph.street        , "text");
	scope.address.number        = uiInputAPI.makeField(true , editMode, _help.number        , _label.number       , _ph.number        , "text");
	scope.address.complement    = uiInputAPI.makeField(true , editMode, _help.complement    , _label.complement   , _ph.complement    , "text");
	scope.address.neighborhood  = uiInputAPI.makeField(true , editMode, _help.neighborhood  , _label.neighborhood , _ph.neighborhood  , "text");
	scope.address.city          = uiInputAPI.makeField(true , editMode, _help.city          , _label.city         , _ph.city          , "text");
	scope.address.state         = uiInputAPI.makeField(true , editMode, _help.state         , _label.state        , _ph.state         , "text");
	scope.address.country       = uiInputAPI.makeField(true , editMode, _help.country       , _label.country      , _ph.country       , "text");
	scope.address.cep           = uiInputAPI.makeField(true , editMode, _help.cep           , _label.cep          , _ph.cep           , "text");
};

var _setEventErrors = function(scope, status){
	scope.status                      = {};
	scope.status.name                 = status.invalidName                 ? "has-error" : "";
	scope.status.description          = status.invalidDescription          ? "has-error" : "";
	scope.status.date                 = status.invalidDate                 ? "has-error" : "";
	scope.status.time                 = status.invalidTime                 ? "has-error" : "";
	scope.status.place                = status.invalidPlace                ? "has-error" : "";
	scope.status.address              = status.invalidAddress              ? "has-error" : "";
	scope.status.address              = {};
	scope.status.address.street       = status.address.invalidStreet       ? "has-error" : "";
	scope.status.address.number       = status.address.invalidNumber       ? "has-error" : "";
	scope.status.address.complement   = status.address.invalidComplement   ? "has-error" : "";
	scope.status.address.neighborhood = status.address.invalidNeighborhood ? "has-error" : "";
	scope.status.address.city         = status.address.invalidCity         ? "has-error" : "";
	scope.status.address.state        = status.address.invalidState        ? "has-error" : "";
	scope.status.address.country      = status.address.invalidCountry      ? "has-error" : "";
	scope.status.address.cep          = status.address.invalidCEP          ? "has-error" : "";
}



angular.module("eventex").controller("eventNewCtrl", function($scope,$modalInstance,uiInputAPI, eventsAPI){
	$scope.entity = {};
	_eventScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(event){
		eventsAPI.create(event).then(function(response){
			if(response.data.success)
				$modalInstance.close(true);
			else
				_setEventErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );

angular.module("eventex").controller("eventEditCtrl", function($scope,$modalInstance,uiInputAPI, eventsAPI, data){
	$scope.entity = data;
	_eventScopeFields($scope, uiInputAPI, true);

	$scope.delete = function(event){
		eventsAPI.delete(event);
		$modalInstance.close('deleted');
	};
	$scope.submit = function(event){
		eventsAPI.update(event).then(function(response){
			if(response.data.success)
				eventsAPI.get(event.id).then(function(response){
					$scope.entity = response.data;
				});
			else
				_setEventErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );