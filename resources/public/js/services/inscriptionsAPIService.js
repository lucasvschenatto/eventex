angular.module("eventex").factory("inscriptionsAPI", function ($http, config){
	var _getInscriptions = function(){
		return $http.get(config.baseUrl+"/inscriptions");
	};
	var _getInscription = function(id){
		return $http.get(config.baseUrl+"/inscriptions/"+id);
	}
	var _saveInscription = function(inscription){
		return $http.post(config.baseUrl+"/inscriptions", inscription) 
	};
	var _deleteInscription = function(inscription){
		$http.delete(config.baseUrl+"/inscriptions/"+inscription.id, {});
	}
	
	return {
		getInscriptions: _getInscriptions,
		getInscription: _getInscription,
		saveInscription: _saveInscription,
		deleteInscription: _deleteInscription
	};
});