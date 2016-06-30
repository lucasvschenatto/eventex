angular.module("eventex").factory("participantsAPI", function ($http){
	var _getParticipants = function(){
		return $http.get("/participants");
	};
	var _getParticipant = function(id){
		return $http.get("/participants/"+id);
	}
	var _createParticipant = function(participant){
		return $http.post("/participants", participant) 
	};
	var _updateParticipant = function(participant){
		return $http.post("/participants", participant) 
	};
	var _deleteParticipant = function(participant){
		$http.delete("/participants/"+participant.id, {});
	}
	
	return {
		getParticipants: _getParticipants,
		getParticipant: _getParticipant,
		createParticipant: _createParticipant,
		updateParticipant: _updeParticipant,
		deleteParticipant: _deleteParticipant
	};
});