angular.module("eventex").factory("inscriptionsAPI", function ($http){
	var _getInscriptions = function(){
		return $http.get("/inscriptions");
	};
	var _getInscriptionsFilteredByActivity = function(activity){
		return $http.get("/inscriptions?activity="+activity.id);
	}
	var _getInscription = function(id){
		return $http.get("/inscriptions/"+id);
	}
	var _createInscription = function(inscription){
		return $http.post("/inscriptions", inscription) 
	};
	var _updateInscription = function(inscription){
		return $http.put("/inscriptions/"+inscription.id, inscription) 
	};
	var _deleteInscription = function(inscription){
		$http.delete("/inscriptions/"+inscription.id, {});
	}
	
	return {
		getAll: _getInscriptions,
		get: _getInscription,
		create: _createInscription,
		update: _updateInscription,
		delete: _deleteInscription,
		getFiltered: _getInscriptionsFilteredByActivity
	};
});