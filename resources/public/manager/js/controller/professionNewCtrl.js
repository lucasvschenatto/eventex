angular.module("eventex").controller("professionNewCtrl", function($scope,$location, professionsAPI){
	$scope.createProfession = function(profession){
		professionsAPI.createProfession(profession);
		$location.path("/manager/professions");
	};
} );