angular.module("eventex").controller("eventFilterCtrl", function($scope,$modalInstance, $state, eventsAPI){
	$scope.field = {
		label: "Evento",
		required:"Campo obrigatório",
	}
	
	eventsAPI.getAll().then(function(response){
		$scope.events = response.data;
	});

	$scope.submit = function(eventId){
		$modalInstance.close(eventId);
	};
	$scope.cancel = function(){
		 $modalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );