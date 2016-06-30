angular.module("eventex").controller("professionDetailsCtrl", function($scope, $location, professionsAPI, profession){
	$scope.profession = profession.data;
	$scope.deleteProfession = function(profession){
		professionSAPI.deleteProfession(profession);
		$location.path("/manager/categories");
	};
	$scope.updateProfession = function(profession){
		professionSAPI.updateProfession(profession);
		professionSAPI.getProfession(profession.id).then(function(response){
			$scope.profession = response.data;
		});
	};
} );