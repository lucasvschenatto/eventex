angular.module("eventex").controller("eventFilterCtrl", function($scope,$modalInstance, $state, eventsAPI){
	$scope.field = {
		label: "Evento",
		name: "evento",
		required:"true",
	}
	
	eventsAPI.getAll().then(function(response){
		$scope.events = response.data;
	});

	$scope.submit = function(event){
		$modalInstance.close(event);
	};
	$scope.cancel = function(){
		 $modalInstance.dismiss("cancel");
		 $state.go("dashboard");
	};
} );