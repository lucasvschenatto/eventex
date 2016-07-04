angular.module("eventex").factory("professionsAPI", function ($http){
	var _getProfessions = function(){
		return $http.get("/professions");
	};
	var _getProfession = function(id){
		return $http.get("/professions/"+id);
	}
	var _createProfession = function(profession){
		return $http.post("/professions", profession) 
	};
	var _updateProfession = function(profession){
		return $http.put("/professions/"+profession.id, profession) 
	};
	var _deleteProfession = function(profession){
		$http.delete("/professions/"+profession.id, {});
	}
	
	return {
		getProfessions: _getProfessions,
		getProfession: _getProfession,
		createProfession: _createProfession,
		updateProfession: _updateProfession,
		deleteProfession: _deleteProfession
	};
});