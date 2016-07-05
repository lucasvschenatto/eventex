angular.module("eventex").factory("eventsAPI", function ($http){
	var _getEvents = function(){
		return $http.get("/events");
	};
	var _getEvent = function(id){
		return $http.get("/events/"+id);
	}
	var _createEvent = function(event){
		return $http.post("/events", event);
	};
	var _updateEvent = function(event){
		return $http.put("/events/"+event.id, event);
	};
	var _deleteEvent = function(event){
		$http.delete("/events/"+event.id, {});
	};
	
	return {
		getAll: _getEvents,
		get: _getEvent,
		create: _createEvent,
		update: _updateEvent,
		delete: _deleteEvent
	};
});