angular.module("eventex").factory("certificatesAPI", function ($http, config){
	var _getCertificate = function(){
		return $http.get(config.baseUrl+"/certificates");
	};
	return {
		getCertificate: _getCertificate,
	};
});