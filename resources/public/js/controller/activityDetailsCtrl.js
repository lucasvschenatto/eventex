angular.module("eventex").controller("activityDetailsCtrl", function($scope, $location, eventsAPI, activity){
	$scope.activity = activity;
	$scope.deleteActivity = function(activity){
		activitiesAPI.deleteActivity(activity);
		$location.path("/");
	};
	$scope.updateActivity = function(activity){
		activitiesAPI.updateActivity(activity);
		activitiesAPI.getActivity(activity.id).then(function(response){
			$scope.activity = response.data;
		});
	}
} );