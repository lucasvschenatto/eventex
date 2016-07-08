angular.module("eventex").controller("categoryFilterCtrl", function($scope,$uibModalInstance, $state, categoriesAPI){
	$scope.field = {
		label: "Categoria",
		required:"Campo obrigatório",
	}
	
	categoriesAPI.getAll().then(function(response){
		$scope.categories = response.data;
	});

	$scope.submit = function(categoryId){
		$uibModalInstance.close(categoryId);
	};
	$scope.cancel = function(){
		 $uibModalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );