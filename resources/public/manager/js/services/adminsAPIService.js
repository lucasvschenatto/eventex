angular.module("eventex").factory("adminsAPI", function ($http){
	var _getAdmins = function(){
		return $http.get("/admins");
	};
	var _getAdmin = function(id){
		return $http.get("/admins/"+id);
	}
	var _createAdmin = function(admin){
		return $http.post("/admins", admin) 
	};
	var _updateAdmin = function(admin){
		return $http.put("/admins/"+admin.id, admin) 
	};
	var _deleteAdmin = function(admin){
		$http.delete("/admins/"+admin.id, {});
	}
	
	return {
		getAll: _getAdmins,
		get: _getAdmin,
		create: _createAdmin,
		update: _updateAdmin,
		delete: _deleteAdmin
	};
});