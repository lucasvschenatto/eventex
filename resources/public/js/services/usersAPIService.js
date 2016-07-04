angular.module("eventex").factory("usersAPI", function ($http){
	var _createUser = function(user){
		return $http.post("/register", user);
	};
	return {
		createUser: _createUser,
	};
});