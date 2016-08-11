

var _activityScopeFields = function(scope, uiInputAPI, editMode){
	scope.name                  = uiInputAPI.makeField(true  ,editMode ,_help.name          ,_label.name          , _ph.name          ,"text");
	scope.description           = uiInputAPI.makeField(true  ,editMode ,_help.description   ,_label.description   , _ph.description   ,"text");
	scope.spots                 = uiInputAPI.makeField(true  ,editMode ,_help.spots         ,_label.spots         , _ph.spots         ,"text");
	scope.duration              = uiInputAPI.makeField(true  ,editMode ,_help.duration      ,_label.duration      , _ph.duration      ,"text");
	scope.points                = uiInputAPI.makeField(true  ,editMode ,_help.points        ,_label.points        , _ph.points        ,"text");
	scope.groupDiscount         = uiInputAPI.makeField(false ,editMode ,_help.groupDiscount ,_label.groupDiscount , _ph.groupDiscount ,""    );
	scope.voucher               = uiInputAPI.makeField(false ,editMode ,_help.voucher       ,_label.voucher       , _ph.voucher       ,""    );
	scope.date                  = uiInputAPI.makeField(true  ,editMode ,_help.date          ,_label.date          , _ph.date          ,"text");
	scope.time                  = uiInputAPI.makeField(true  ,editMode ,_help.time          ,_label.time          , _ph.time          ,"text");
	scope.place                 = uiInputAPI.makeField(true  ,editMode ,_help.place         ,_label.place         , _ph.place         ,"text");
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

var _setActivityErrors = function(scope, status){
	scope.status                      = {};
	scope.status.name                 = status.invalidName          ? "has-error" : "";
	scope.status.description          = status.invalidDescription   ? "has-error" : "";
	scope.status.spots                = status.invalidSpots         ? "has-error" : "";
	scope.status.duration             = status.invalidDuration      ? "has-error" : "";
	scope.status.points               = status.invalidPoints        ? "has-error" : "";
	scope.status.groupDiscount        = status.invalidGroupDiscount ? "has-error" : "";
	scope.status.voucher              = status.invalidVoucher       ? "has-error" : "";
	scope.status.date                 = status.invalidDate          ? "has-error" : "";
	scope.status.time                 = status.invalidTime          ? "has-error" : "";
	scope.status.place                = status.invalidPlace         ? "has-error" : "";
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

angular.module("eventex").controller("activityNewCtrl", function($scope,$uibModalInstance,uiInputAPI, activitiesAPI, data){
	$scope.entity = {};
	$scope.entity.eventId = data.id;
	$scope.entity.name = data.name;
	$scope.entity.description = data.description;
	$scope.entity.date = data.date;
	$scope.entity.time = data.time;
	$scope.entity.place = data.place;
	$scope.entity.address = data.address;
	$scope.status = {address:{}};
	_activityScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(activity){
		activitiesAPI.create(activity).then(function(response){
			if(response.data.success)
				$uibModalInstance.close(true);
			else
				_setActivityErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$uibModalInstance.dismiss();
	};
} );




angular.module("eventex").controller("activityEditCtrl", function($scope, $uibModalInstance,uiInputAPI, activitiesAPI, data){
	$scope.entity = data;
	_activityScopeFields($scope, uiInputAPI, true);

	
	$scope.delete = function(activity){
		activitiesAPI.delete(activity);
		$uibModalInstance.close('deleted');
	};
	$scope.submit = function(activity){
		activitiesAPI.update(activity).then(function(response){
			if(response.data.success)
				$uibModalInstance.close("updated");
			else
				_setActivityErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$uibModalInstance.dismiss();
	};
} );