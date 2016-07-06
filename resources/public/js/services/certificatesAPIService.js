angular.module("eventex").factory("certificatesAPI", function ($http){
	var _get = function(){
		return $http.get("/certificates");
	};
	return {
		get: _get,
	};
});