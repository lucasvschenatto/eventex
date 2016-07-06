angular.module("eventex").controller("activityFilterCtrl", function($scope,$modalInstance, $state, activitiesAPI){
	$scope.field = {
		label: "Atividade",
		name: "atividade",
		required:"true",
	}
	
	activitiesAPI.getAll().then(function(response){
		$scope.activities = response.data;
	});

	$scope.submit = function(activity){
		$modalInstance.close(activity);
	};
	$scope.cancel = function(){
		 $modalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );