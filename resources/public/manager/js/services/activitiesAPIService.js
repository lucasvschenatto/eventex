angular.module("eventex").factory("activitiesAPI", function ($http){
	var _getActivities = function(){
		return $http.get("/activities");
	};
	var _getActivitiesFilteredByEvent = function(event){
		return $http.get("/activities?event="+event.id);
	}
	var _getActivity = function(id){
		return $http.get("/activities/"+id);
	}
	var _createActivity = function(activity){
		return $http.post("/activities", activity) 
	};
	var _updateActivity = function(activity){
		return $http.put("/activities/"+activity.id, activity) 
	};
	var _deleteActivity = function(activity){
		$http.delete("/activities/"+activity.id, {});
	}
	
	return {
		getActivities: _getActivities,
		getActivity: _getActivity,
		createActivity: _createActivity,
		updateActivity: _updateActivity,
		deleteActivity: _deleteActivity,
		getActivitiesFilteredByEvent: _getActivitiesFilteredByEvent
	};
});