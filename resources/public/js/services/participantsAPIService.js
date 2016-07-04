angular.module("eventex").factory("participantsAPI", function ($http){
	var _createParticipant = function(participant){
		return $http.post("/participants", participant);
	};
	return {
		createParticipant: _createParticipant,
	};
});