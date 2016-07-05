angular.module("eventex").controller("inscriptionsCtrl", function($scope,$state, modal, inscriptions){
	$scope.inscriptions = inscriptions.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/inscriptionNew.html","inscriptionNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(inscription){
		modal("manager/view/inscriptionEdit.html","inscriptionEditCtrl", inscription).then(function(changed){
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