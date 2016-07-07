angular.module("eventex").controller("categoryFilterCtrl", function($scope,$modalInstance, $state, categoriesAPI){
	$scope.field = {
		label: "Categoria",
		required:"Campo obrigatório",
	}
	
	categoriesAPI.getAll().then(function(response){
		$scope.categories = response.data;
	});

	$scope.submit = function(categoryId){
		$modalInstance.close(categoryId);
	};
	$scope.cancel = function(){
		 $modalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );