angular.module("eventex").controller("adminsCtrl", function($scope,$state, modal, admins){
	$scope.admins = admins.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/adminNew.html","adminNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(admin){
		modal("manager/view/adminEdit.html","adminEditCtrl", admin).then(function(changed){
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