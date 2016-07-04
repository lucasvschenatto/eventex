angular.module("eventex").controller("categoryNewCtrl", function($scope,$location, categoriesAPI){
	$scope.createCategory = function(category){
		categoriesAPI.createCategory(category);
		$location.path("/manager/categories");
	};
} );