angular.module("eventex").factory("participantsAPI", function ($http){
	var _create = function(participant){
		return $http.post("/participants", participant);
	};
	return {
		create: _create,
	};
});