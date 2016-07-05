angular.module("eventex").controller("associatesCtrl", function($scope,$state, associatesAPI, modal, category){
	$scope.category = category;

	var loadFiltered = function(){
		associatesAPI.getFiltered(category).then(function(result){
			$scope.associates = result.data;
		});
	};

	loadFiltered();

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/associateNew.html","associateNewCtrl", category).then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(associate){
		modal("manager/view/associateEdit.html","associateEditCtrl", associate).then(function(changed){
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