angular.module("eventex").controller("associateDetailsCtrl", function($scope, $location, associatesAPI, associate){
	$scope.associate = associate.data;
	$scope.deleteAssociate = function(associate){
		associatesAPI.deleteAssociate(associate);
		$location.path("/manager/categories/"+associate.categoryId);
	};
	$scope.updateAssociate = function(associate){
		associatesAPI.updateAssociate(associate);
		associatesAPI.getAssociate(associate.id).then(function(response){
			$scope.associate = response.data;
		});
	}
} );