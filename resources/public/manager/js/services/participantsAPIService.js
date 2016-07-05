angular.module("eventex").factory("participantsAPI", function ($http){
	var _getParticipants = function(){
		return $http.get("/participants");
	};
	var _getParticipant = function(id){
		return $http.get("/participants/"+id);
	}
	var _createParticipant = function(participant){
		return $http.post("/participants", participant);
	};
	var _updateParticipant = function(participant){
		return $http.put("/participants/"+participant.id, participant);
	};
	var _deleteParticipant = function(participant){
		$http.delete("/participants/"+participant.id, {});
	};
	
	return {
		getAll: _getParticipants,
		get: _getParticipant,
		create: _createParticipant,
		update: _updateParticipant,
		delete: _deleteParticipant
	};
});