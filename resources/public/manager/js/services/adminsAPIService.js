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
		getAdmins: _getAdmins,
		getAdmin: _getAdmin,
		createAdmin: _createAdmin,
		updateAdmin: _updateAdmin,
		deleteAdmin: _deleteAdmin
	};
});