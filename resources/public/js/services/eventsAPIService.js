angular.module("eventex").factory("eventsAPI", function ($http, config){
	var _getEvents = function(){
		return $http.get(config.baseUrl+"/events");
	};
	var _getEvent = function(id){
		return $http.get(config.baseUrl+"/events/"+id);
	}
	var _saveEvent = function(event){
		return $http.post(config.baseUrl+"/events", event) 
	};
	var _deleteEvent = function(event){
		$http.delete(config.baseUrl+"/events/"+event.id, {});
	}
	
	return {
		getEvents: _getEvents,
		getEvent: _getEvent,
		saveEvent: _saveEvent,
		deleteEvent: _deleteEvent
	};
});