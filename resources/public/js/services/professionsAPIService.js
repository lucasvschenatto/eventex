angular.module("eventex").factory("professionsAPI", function ($http, config){
	var _getProfessions = function(){
		return $http.get(config.baseUrl+"/professions");
	};
	var _getProfession = function(id){
		return $http.get(config.baseUrl+"/professions/"+id);
	}
	var _saveProfession = function(profession){
		return $http.post(config.baseUrl+"/professions", profession) 
	};
	var _deleteProfession = function(profession){
		$http.delete(config.baseUrl+"/professions/"+profession.id, {});
	}
	
	return {
		getProfessions: _getProfessions,
		getProfession: _getProfession,
		saveProfession: _saveProfession,
		deleteProfession: _deleteProfession
	};
});