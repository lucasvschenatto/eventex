angular.module("eventex").controller("activitiesCtrl", function($scope,$state, activitiesAPI, event, modal){
	$scope.event = event;

	var loadFiltered = function(){
		activitiesAPI.getActivitiesFilteredByEvent(event).then(function(result){
			$scope.activities = result.data;
		});
	};

	activitiesAPI = loadFiltered();

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/activityNew.html","activityNewCtrl", event).then(function(result){
			$state.reload();
		});
	};
	$scope.details = function(activity){
		modal("manager/view/activityDetails.html","activityDetailsCtrl", activity).then(function(changed){
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