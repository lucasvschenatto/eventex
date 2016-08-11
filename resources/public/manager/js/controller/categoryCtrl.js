var _categoryScopeFields = function(scope, uiInputAPI, editMode){
	scope.name                  = uiInputAPI.makeField(true  ,editMode ,_help.name                  ,_label.name                  , _ph.name                  ,"text");
	scope.description           = uiInputAPI.makeField(true  ,editMode ,_help.description           ,_label.description           , _ph.description           ,"text");
	scope.discount              = uiInputAPI.makeField(true  ,editMode ,_help.discount              ,_label.discount              , _ph.discount              ,"text");
	scope.needCodeAtInscription = uiInputAPI.makeField(false ,editMode ,_help.needCodeAtInscription ,_label.needCodeAtInscription , _ph.needCodeAtInscription ,"");
};

var _setCategoryErrors = function(scope, status){
	scope.status                      = {};
	scope.status.name                  = status.invalidName                  ? "has-error" : "";
	scope.status.description           = status.invalidDescription           ? "has-error" : "";
	scope.status.discount              = status.invalidDiscount              ? "has-error" : "";
	scope.status.needCodeAtInscription = status.invalidNeedCodeAtInscription ? "has-error" : "";
};



angular.module("eventex").controller("categoryNewCtrl", function($scope,$uibModalInstance,uiInputAPI, categoriesAPI){
	$scope.entity = {};
	_categoryScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(category){
		categoriesAPI.create(category).then(function(response){
			if(response.data.success)
				$uibModalInstance.close(true);
			else
				_setCategoryErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$uibModalInstance.dismiss();
	};
} );
angular.module("eventex").controller("categoryEditCtrl", function($scope,$uibModalInstance,uiInputAPI, categoriesAPI, data){
	$scope.entity = data;
	_categoryScopeFields($scope, uiInputAPI, true);

	$scope.delete = function(category){
		categoriesAPI.delete(category);
		$uibModalInstance.close('deleted');
	};
	$scope.submit = function(category){
		categoriesAPI.update(category).then(function(response){
			if(response.data.success)
				$uibModalInstance.close("updated");
			else
				_setCategoryErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$uibModalInstance.dismiss();
	};
} );