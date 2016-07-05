angular.module("eventex").controller("professionsCtrl", function($scope,$state, modal, professions){
	$scope.professions = professions.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/professionNew.html","professionNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(profession){
		modal("manager/view/professionEdit.html","professionEditCtrl", profession).then(function(changed){
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