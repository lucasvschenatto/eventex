angular.module("eventex").controller("activityFilterCtrl", function($scope,$modalInstance, $state, activitiesAPI){
	$scope.field = {
		label: "Atividade",
		required:"Campo obrigatório",
	}
	
	activitiesAPI.getAll().then(function(response){
		$scope.activities = response.data;
	});

	$scope.submit = function(activityId){
		$modalInstance.close(activityId);
	};
	$scope.cancel = function(){
		 $modalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );