var _inscriptionScopeFields = function(scope, uiInputAPI, editMode){
	scope.participant   = uiInputAPI.makeField(true  ,editMode ,_help.participant   ,_label.participant   , _ph.participant   ,"text");
	scope.activity      = uiInputAPI.makeField(false ,editMode ,_help.activity      ,_label.activity      , _ph.activity      ,"text");
	scope.category      = uiInputAPI.makeField(true  ,editMode ,_help.category      ,_label.category      , _ph.category      ,"text");
	scope.associateCode = uiInputAPI.makeField(true  ,editMode ,_help.associateCode ,_label.associateCode , _ph.associateCode ,"text");
};

var _setInscriptionErrors = function(scope, status){
	scope.status                      = {};
	scope.status.participant   = status.invalidParticipantId ? "has-error" : "";
	scope.status.activity      = status.invalidActivityId    ? "has-error" : "";
	scope.status.category      = status.invalidCategoryId    ? "has-error" : "";
	scope.status.associateCode = status.invalidAssociateCode ? "has-error" : "";
}



angular.module("eventex").controller("inscriptionNewCtrl", function($scope,$uibModalInstance,uiInputAPI, inscriptionsAPI){
	$scope.entity = {};
	_inscriptionScopeFields($scope, uiInputAPI, true);

	$scope.submit = function(inscription){
		inscriptionsAPI.create(inscription).then(function(response){
			if(response.data.success)
				$uibModalInstance.close(true);
			else
				_setInscriptionErrors($scope,response.data);
		});
	};
	$scope.cancel = function(){
		$uibModalInstance.dismiss();
	};
} );