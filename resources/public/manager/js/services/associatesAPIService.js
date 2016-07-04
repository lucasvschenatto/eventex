angular.module("eventex").factory("associatesAPI", function ($http){
	var _getAssociates = function(){
		return $http.get("/associates");
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
		getAssociates: _getAssociates,
		getAssociate: _getAssociate,
		createAssociate: _createAssociate,
		updateAssociate: _updateAssociate,
		deleteAssociate: _deleteAssociate
	};
});