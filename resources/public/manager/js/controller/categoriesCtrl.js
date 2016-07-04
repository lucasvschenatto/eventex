angular.module("eventex").controller("categoriesCtrl", function($scope,$state, categories){
	$scope.categories = categories.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		$state.go("categories.new");
	}
} );