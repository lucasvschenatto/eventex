angular.module("eventex").factory("activitiesAPI", function ($http, config){
	var _getActivities = function(){
		return $http.get(config.baseUrl+"/activities");
	};
	var _getActivity = function(id){
		return $http.get(config.baseUrl+"/activities/"+id);
	}
	var _saveActivity = function(activity){
		return $http.post(config.baseUrl+"/activities", activity) 
	};
	var _deleteActivity = function(activity){
		$http.delete(config.baseUrl+"/activities/"+activity.id, {});
	}
	
	return {
		getActivities: _getActivities,
		getActivity: _getActivity,
		saveActivity: _saveActivity,
		deleteActivity: _deleteActivity
	};
});