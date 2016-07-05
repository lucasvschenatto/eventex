angular.module("eventex").factory("associatesAPI", function ($http){
	var _getAssociates = function(){
		return $http.get("/associates");
	};
	var _getAssociatesFilteredByCategory = function(category){	
		return $http.get("/associates?category="+category.id);
	};
	var _getAssociate = function(id){
		return $http.get("/associates/"+id);
	}
	var _createAssociate = function(associate){
		return $http.post("/associates", associate) 
	};
	var _updateAssociate = function(associate){
		return $http.put("/associates/"+associate.id, associate) 
	};
	var _deleteAssociate = function(associate){
		$http.delete("/associates/"+associate.id, {});
	}
	
	return {
		getAll: _getAssociates,
		get: _getAssociate,
		create: _createAssociate,
		update: _updateAssociate,
		delete: _deleteAssociate,
		getFiltered:_getAssociatesFilteredByCategory
	};
});