angular.module("eventex").controller("activityNewCtrl", function($scope,$location, activitiesAPI, event){
	$scope.activity = {};
	$scope.activity.eventId = event.data.id;
	$scope.activity.name = event.data.name;
	$scope.activity.description = event.data.description;
	$scope.activity.date = event.data.date;
	$scope.activity.time = event.data.time;
	$scope.activity.place = event.data.place;
	$scope.activity.address = event.data.address;

	$scope.createActivity = function(activity){
		activitiesAPI.createActivity(activity);
		$location.path("/");
	};
} );