angular.module("eventex").controller("activityDetailsCtrl", function($scope, $location, activitiesAPI, inscriptionsAPI, activity){
	$scope.activity = activity.data;
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