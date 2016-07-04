angular.module("eventex").factory("certificatesAPI", function ($http){
	var _getCertificate = function(){
		return $http.get("/certificates");
	};
	return {
		getCertificate: _getCertificate,
	};
});