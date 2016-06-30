angular.module("eventex").controller("categoriesCtrl", function($scope,$location, categories){
	$scope.categories = categories.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.newCategory = function(){
		$location.path($location.path()+"/new_category");
	}
} );