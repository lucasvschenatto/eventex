angular.module("eventex").controller("activityFilterCtrl", function($scope,$uibModalInstance, $state, activitiesAPI){
	$scope.field = {
		label: "Atividade",
		required:"Campo obrigatório",
	}
	
	activitiesAPI.getAll().then(function(response){
		$scope.activities = response.data;
	});

	$scope.submit = function(activityId){
		$uibModalInstance.close(activityId);
	};
	$scope.cancel = function(){
		 $uibModalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );