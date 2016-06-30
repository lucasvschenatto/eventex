angular.module("eventex").controller("categoryDetailsCtrl", function($scope, $location, categoriesAPI, category, associates){
	$scope.category = category.data;
	$scope.associates = associates.data;
	$scope.deleteCategory = function(category){
		categoriesAPI.deleteCategory(category);
		$location.path("/manager/categories");
	};
	$scope.updateCategory = function(category){
		categoriesAPI.updateCategory(category);
		categoriesAPI.getCategory(category.id).then(function(response){
			$scope.category = response.data;
		});
	};
	$scope.newAssociate = function(){
		$location.path($location.path()+"/new_associate");
	}
} );