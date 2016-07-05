angular.module("eventex").controller("categoryFilterCtrl", function($scope,$modalInstance, $state, categoriesAPI){
	$scope.field = {
		label: "Categoria",
		name: "categoria",
		required:"true",
	}
	
	categoriesAPI.getAll().then(function(response){
		$scope.categories = response.data;
	});

	$scope.submit = function(category){
		$modalInstance.close(category);
	};
	$scope.cancel = function(){
		 $modalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );