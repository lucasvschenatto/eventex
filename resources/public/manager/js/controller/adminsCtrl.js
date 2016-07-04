angular.module("eventex").controller("adminsCtrl", function($scope,$state, admins){
	$scope.admins = admins.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		$state.go("admins.new");
	};
} );