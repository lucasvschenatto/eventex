var _adminScopeFields = function(scope, uiInputAPI, editMode){
	scope.user = uiInputAPI.makeField(true  ,editMode ,_help.user ,_label.user , _ph.user ,"text");
	scope.name = uiInputAPI.makeField(true  ,editMode ,_help.name ,_label.name , _ph.name ,"text");
	scope.role = uiInputAPI.makeField(false ,editMode ,_help.role ,_label.role , _ph.role ,"text");
};

var _setAdminErrors = function(scope, status){
	scope.status       = {};
	scope.status.user  = status.invalidUserId ? "has-error" : "";
	scope.status.name  = status.invalidName   ? "has-error" : "";
	scope.status.role  = status.invalidRole   ? "has-error" : "";
}



angular.module("eventex").controller("adminNewCtrl", function($scope,$uibModalInstance,uiInputAPI, adminsAPI){
	$scope.entity = {};
	_adminScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(admin){
		adminsAPI.create(admin).then(function(response){
			if(response.data.success)
				$uibModalInstance.close(true);
			else
				_setAdminErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$uibModalInstance.dismiss();
	};
} );