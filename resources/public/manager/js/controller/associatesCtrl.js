angular.module("eventex").controller("associatesCtrl", function($scope,$state, associates){
	$scope.associates = associates.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		$state.go("associates.new");
	};
} );