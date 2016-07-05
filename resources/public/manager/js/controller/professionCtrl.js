var _professionScopeFields = function(scope, uiInputAPI, editMode){
	scope.name                  = uiInputAPI.makeField(true  ,editMode ,_help.name                  ,_label.name                  , _ph.name                  ,"text");
	scope.description           = uiInputAPI.makeField(false ,editMode ,_help.description           ,_label.description           , _ph.description           ,"text");
};

var _setProfessionErrors = function(scope, status){
	scope.status                      = {};
	scope.status.name                  = status.invalidName                  ? "has-error" : "";
	scope.status.description           = status.invalidDescription           ? "has-error" : "";
}



angular.module("eventex").controller("professionNewCtrl", function($scope,$modalInstance,uiInputAPI, professionsAPI){
	$scope.entity = {};
	_professionScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(profession){
		professionsAPI.create(profession).then(function(response){
			if(response.data.success)
				$modalInstance.close(true);
			else
				_setProfessionErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );
angular.module("eventex").controller("professionEditCtrl", function($scope,$modalInstance,uiInputAPI, data, professionsAPI){
	$scope.entity = data;
	_professionScopeFields($scope, uiInputAPI, true);

	$scope.delete = function(profession){
		professionsAPI.delete(profession);
		$modalInstance.close('deleted');
	};
	$scope.submit = function(profession){
		professionsAPI.update(profession).then(function(response){
			if(response.data.success)
				professionsAPI.get(profession.id).then(function(response){
					$scope.entity = response.data;
				});
			else
				_setProfessionErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );