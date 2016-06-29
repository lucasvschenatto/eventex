angular.module("eventex").controller("activityNewCtrl", function($scope,$location, activitiesAPI){
	$scope.createActivity = function(activity){
		activitiesAPI.createActivity(activity);
		$location.path("/");
	};
} );