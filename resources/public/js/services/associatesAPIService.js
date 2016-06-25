angular.module("eventex").factory("associatesAPI", function ($http, config){
	var _getAssociates = function(){
		return $http.get(config.baseUrl+"/associates");
	};
	var _getAssociate = function(id){
		return $http.get(config.baseUrl+"/associates/"+id);
	}
	var _saveAssociate = function(associate){
		return $http.post(config.baseUrl+"/associates", associate) 
	};
	var _deleteAssociate = function(associate){
		$http.delete(config.baseUrl+"/associates/"+associate.id, {});
	}
	
	return {
		getAssociates: _getAssociates,
		getAssociate: _getAssociate,
		saveAssociate: _saveAssociate,
		deleteAssociate: _deleteAssociate
	};
});