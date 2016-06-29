angular.module("eventex").config(function ($routeProvider) {
	$routeProvider.when("/error",{
		templateUrl: "view/error.html"
	});
	$routeProvider.when("/", {
		templateUrl: "view/events.html",
		controller: "eventsCtrl",
		resolve: {
			events: function (eventsAPI){
				return eventsAPI.getEvents();
			}
		}
	});
	$routeProvider.when("/new_event", {
		templateUrl: "view/eventNew.html",
		controller: "eventNewCtrl"
	});
	$routeProvider.when("/:id", {
		templateUrl: "view/eventDetails.html",
		controller: "eventDetailsCtrl",
		resolve: {
			event: function (eventsAPI, $route){
				return eventsAPI.getEvent($route.current.params.id);
			},
			activities: function(activitiesAPI, $route){
				return activitiesAPI.getActivities().then(function(response){
					response.data = response.data.filter(function(activity){
						return activity.eventId == $route.current.params.id;
					});
					return response;
				});
			}
		}
	});
	$routeProvider.when("/:eventId/new_activity",{
		templateUrl: "view/activityNew.html",
		controller: "activityNewCtrl",
		resolve: {
			event: function(eventsAPI, $route){
				return eventsAPI.getEvent($route.current.params.eventId);
			}
		}
	});
	$routeProvider.when("/:eventId/:activityId",{
		templateUrl: "view/activityDetails.html",
		controller: "activityDetailsCtrl",
		resolve: {
			activity: function(activitiesAPI, $route){
				return activitiesAPI.getActivity($route.current.params.activityId);
			},
			event: function(eventsAPI, $route){
				return eventsAPI.getEvent($route.current.params.eventId);
			}
		}
	});
	$routeProvider.otherwise({redirectTo:"/"});
});