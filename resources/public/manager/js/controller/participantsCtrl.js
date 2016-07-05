angular.module("eventex").controller("participantsCtrl", function($scope,$state, modal, participants){
	$scope.participants = participants.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.new = function(){
		var _new = modal("manager/view/participantNew.html","participantNewCtrl").then(function(result){
			$state.reload();
		});
	};
	$scope.edit = function(participant){
		modal("manager/view/participantEdit.html","participantEditCtrl", participant).then(function(changed){
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