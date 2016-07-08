angular.module("eventex").controller("eventFilterCtrl", function($scope,$uibModalInstance, $state, eventsAPI){
	$scope.field = {
		label: "Evento",
		required:"Campo obrigatório",
	}
	
	eventsAPI.getAll().then(function(response){
		$scope.events = response.data;
	});

	$scope.submit = function(eventId){
		$uibModalInstance.close(eventId);
	};
	$scope.cancel = function(){
		 $uibModalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );