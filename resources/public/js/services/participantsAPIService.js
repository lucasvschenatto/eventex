angular.module("eventex").factory("participantsAPI", function ($http, config){
	var _getParticipants = function(){
		return $http.get(config.baseUrl+"/participants");
	};
	var _getParticipant = function(id){
		return $http.get(config.baseUrl+"/participants/"+id);
	}
	var _saveParticipant = function(participant){
		return $http.post(config.baseUrl+"/participants", participant) 
	};
	var _deleteParticipant = function(participant){
		$http.delete(config.baseUrl+"/participants/"+participant.id, {});
	}
	
	return {
		getParticipants: _getParticipants,
		getParticipant: _getParticipant,
		saveParticipant: _saveParticipant,
		deleteParticipant: _deleteParticipant
	};
});