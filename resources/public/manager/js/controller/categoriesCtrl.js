angular.module("eventex").controller("categoriesCtrl", function($scope,$state, modal, categories){
	$scope.categories = categories.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/categoryNew.html","categoryNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(category){
		modal("manager/view/categoryEdit.html","categoryEditCtrl", category).then(function(changed){
			if(changed)
				$state.reload();
		});
	};
	$scope.reload = function(){
		$state.reload();
	};
	$scope.back = function(){
		$state.go("dashboard");
	};
} );