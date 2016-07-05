angular.module("eventex").controller("eventsCtrl", function($scope,$state, modal, events){
	$scope.events = events.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/eventNew.html","eventNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(event){
		modal("manager/view/eventEdit.html","eventEditCtrl", event).then(function(changed){
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