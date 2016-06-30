angular.module("eventex").controller("professionsCtrl", function($scope,$location, professions){
	$scope.professions = professions.data;

	$scope.orderBy = function(field){
		$scope.orderCriteria = field;
		$scope.orderDirection = !$scope.orderDirection;
	};
	$scope.newProfession = function(){
		$location.path($location.path()+"/new_profession");
	}
} );