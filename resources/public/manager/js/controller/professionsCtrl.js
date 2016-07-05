angular.module("eventex").controller("professionsCtrl", function($scope,$state, modal, professionsAPI){
	professionsAPI.getAll().then(function(result){
		$scope.professions = result.data;
	});

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/professionNew.html","professionNewCtrl").then(function(created){
			if(created)
				$state.reload();
		});
	};
	$scope.delete = function(profession){
		professionsAPI.delete(profession);
		$state.reload();
	};
	$scope.reload = function(){
		$state.reload();
	};
	$scope.back = function(){
		$state.go("dashboard");
	};
} );