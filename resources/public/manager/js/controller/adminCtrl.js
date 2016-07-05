var _adminScopeFields = function(scope, uiInputAPI, editMode){
	scope.name = uiInputAPI.makeField(true  ,editMode ,_help.name ,_label.name , _ph.name ,"text");
	scope.role = uiInputAPI.makeField(false ,editMode ,_help.role ,_label.role , _ph.role ,"text");
	scope.user = uiInputAPI.makeField(true  ,editMode ,_help.user ,_label.user , _ph.user ,"text");
};

var _setAdminErrors = function(scope, status){
	scope.status       = {};
	scope.status.name  = status.invalidName ? "has-error" : "";
	scope.status.role  = status.invalidRole ? "has-error" : "";
	scope.status.user  = status.invalidUser ? "has-error" : "";
}



angular.module("eventex").controller("adminNewCtrl", function($scope,$modalInstance,uiInputAPI, adminsAPI){
	$scope.entity = {};
	_adminScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(admin){
		adminsAPI.create(admin).then(function(response){
			if(response.data.success)
				$modalInstance.close(true);
			else
				_setAdminErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );
angular.module("eventex").controller("adminEditCtrl", function($scope,$modalInstance,uiInputAPI, adminsAPI, data){
	$scope.entity = data;
	_adminScopeFields($scope, uiInputAPI, true);

	$scope.delete = function(admin){
		adminsAPI.delete(admin);
		$modalInstance.close('deleted');
	};
	$scope.submit = function(admin){
		adminsAPI.update(admin).then(function(response){
			if(response.data.success)
				adminsAPI.get(admin.id).then(function(response){
					$scope.entity = response.data;
				});
			else
				_setAdminErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$modalInstance.dismiss();
	};
} );