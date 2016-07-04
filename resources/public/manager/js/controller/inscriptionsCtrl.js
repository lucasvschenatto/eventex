angular.module("eventex").controller("inscriptionsCtrl", function($scope,$state, inscriptions){
	$scope.inscriptions = inscriptions.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		$state.go("inscriptions.new");
	};
} );