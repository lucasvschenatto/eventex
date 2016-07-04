angular.module("eventex").controller("participantsCtrl", function($scope,$state, participants){
	$scope.participants = participants.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		$state.go("participants.new");
	};
} );