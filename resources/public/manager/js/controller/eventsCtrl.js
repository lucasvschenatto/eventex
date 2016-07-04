angular.module("eventex").controller("eventsCtrl", function($scope,$state, events){
	$scope.events = events.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		$state.go("events.new");
	};
} );