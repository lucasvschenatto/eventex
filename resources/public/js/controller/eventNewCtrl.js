angular.module("eventex").controller("eventNewCtrl", function($scope,$location, eventsAPI){
	$scope.createEvent = function(event){
		eventsAPI.createEvent(event);
		$location.path("/");
	};
} );