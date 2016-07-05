

var _associateScopeFields = function(scope, uiInputAPI, editMode){
	scope.name       = uiInputAPI.makeField(true  ,editMode ,_help.name       ,_label.name       , _ph.name       ,"text");
	scope.code       = uiInputAPI.makeField(true  ,editMode ,_help.code       ,_label.code       , _ph.code       ,"text");
	scope.updateDate = uiInputAPI.makeField(true  ,editMode ,_help.updateDate ,_label.updateDate , _ph.updateDate ,"text");
	scope.active     = uiInputAPI.makeField(false ,editMode ,_help.active     ,_label.active     , _ph.active     ,"");
};

var _setAssociateErrors = function(scope, status){
	scope.status                      = {};
	scope.status.name       = status.invalidName       ? "has-error" : "";
	scope.status.code       = status.invalidCode       ? "has-error" : "";
	scope.status.updateDate = status.invalidUpdateDate ? "has-error" : "";
	scope.status.active     = status.invalidActive     ? "has-error" : "";
}

angular.module("eventex").controller("associateNewCtrl", function($scope,$modalInstance,uiInputAPI, associatesAPI, data){
	$scope.entity = {};
	$scope.entity.categoryId = data.id;
	_associateScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(associate){
		associatesAPI.create(associate).then(function(response){
			if(response.data.success)
				$modalInstance.close(true);
			else
				_setAssociateErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );

angular.module("eventex").controller("associateEditCtrl", function($scope, $modalInstance,uiInputAPI, associatesAPI, data){
	$scope.entity = data;
	_associateScopeFields($scope, uiInputAPI, true);

	$scope.delete = function(associate){
		associatesAPI.delete(associate);
		$modalInstance.close('deleted');
	};
	$scope.submit = function(associate){
		associatesAPI.update(associate).then(function(response){
			if(response.data.success)
				associatesAPI.get(associate.id).then(function(response){
					$scope.entity = response.data;
				});
			else
				_setAssociateErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );