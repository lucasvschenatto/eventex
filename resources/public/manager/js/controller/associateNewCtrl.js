angular.module("eventex").controller("associateNewCtrl", function($scope,$location, associatesAPI, category){
	$scope.associate = {};
	$scope.associate.categoryId = category.data.id;

	$scope.createAssociate = function(associate){
		associatesAPI.createAssociate(associate);
		$location.path("/manager/categories/"+associate.categoryId);
	};
} );