angular.module("eventex").controller("eventsCtrl", function($scope,$location, events){
	$scope.events = events.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.newEvent = function(){
		$location.path($location.path()+"/new_event");
	}
} );