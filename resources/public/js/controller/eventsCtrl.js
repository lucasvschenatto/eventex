angular.module("eventex").controller("eventsCtrl", function($scope,$location, eventsAPI, events){
	$scope.events = events.data;

	$scope.orderBy = function(campo){
		$scope.orderCriteria = campo;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.newEvent = function(){
		$location.path("/events/new");
	}
} );