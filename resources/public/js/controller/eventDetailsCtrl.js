angular.module("eventex").controller("eventDetailsCtrl", function($scope, $location, eventsAPI, event, activities){
	$scope.event = event.data;
	$scope.activities = activities.data;
	$scope.deleteEvent = function(event){
		eventsAPI.deleteEvent(event);
		$location.path("/");
	};
	$scope.updateEvent = function(event){
		eventsAPI.updateEvent(event);
		eventsAPI.getEvent(event.id).then(function(response){
			$scope.event = response.data;
		});
	};
	$scope.newActivity = function(){
		$location.path($location.path()+"/new");
	}
} );