angular.module("eventex").controller("inscriptionsCtrl", function($scope,$state, modal, activity, inscriptionsAPI){
	$scope.activity = activity;
	inscriptionsAPI.getFiltered(activity).then(function(response){
		$scope.inscriptions = response.data;
	});

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/inscriptionNew.html","inscriptionNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.delete = function(inscription){
		inscriptionsAPI.delete(inscription);
		$state.reload();
	};
	$scope.reload = function(){
		$state.reload();
	};
	$scope.back = function(){
		$state.go("dashboard");
	};
} );