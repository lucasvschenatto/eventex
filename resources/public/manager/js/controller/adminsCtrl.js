angular.module("eventex").controller("adminsCtrl", function($scope,$state, modal, adminsAPI){
	adminsAPI.getAll().then(function(response){
		$scope.admins = response.data;	
	})

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/adminNew.html","adminNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.delete = function(admin){
		adminsAPI.delete(admin);
		$state.reload();
	};
	$scope.reload = function(){
		$state.reload();
	};
	$scope.back = function(){
		$state.go("dashboard");
	};
} );