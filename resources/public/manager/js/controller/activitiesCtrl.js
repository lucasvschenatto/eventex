angular.module("eventex").controller("activitiesCtrl", function($scope,$state, activitiesAPI, event, modal){
	$scope.event = event;

	var loadFiltered = function(){
		activitiesAPI.getFiltered(event).then(function(result){
			$scope.activities = result.data;
		});
	};

	loadFiltered();

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/activityNew.html","activityNewCtrl", event).then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(activity){
		modal("manager/view/activityEdit.html","activityEditCtrl", activity).then(function(changed){
			if(changed)
				$state.reload();
		});
	};
	$scope.reload = function(){
		$state.reload();
	};
	$scope.back = function(){
		$state.go("dashboard");
	};

	
} );