angular.module("eventex").factory("usersAPI", function ($http){
	var _create = function(user){
		return $http.post("/register", user);
	};
	var _login = function(credentials){
		return $http.post("/login", credentials);
	};
	var _logout = function(){
		return $http.post("/logout");
	};
	var _readUser = function(){
		return $http.get("/read-user");
	};
	return {
		create: _create,
		login : _login,
		logout: _logout,
		readUser: _readUser
	};

});