angular.module("eventex").config(function ($routeProvider) {
	var _managerBase = "/manager";
	$routeProvider.when("/error",{
		templateUrl: "view/error.html"
	});

	$routeProvider.when(_managerBase, {
		templateUrl: "manager/view/dashboard.html"
	});

	$routeProvider.when(_managerBase+"/categories", {
		templateUrl: "manager/view/categories.html",
		controller: "categoriesCtrl",
		resolve: {
			categories: function (categoriesAPI){
				return categoriesAPI.getCategories();
			}
		}
	});
	$routeProvider.when(_managerBase+"/categories/new_category", {
		templateUrl: "manager/view/categoryNew.html",
		controller: "categoryNewCtrl"
	});
	$routeProvider.when(_managerBase+"/categories/:id", {
		templateUrl: "manager/view/categoryDetails.html",
		controller: "categoryDetailsCtrl",
		resolve: {
			category: function (categoriesAPI, $route){
				return categoriesAPI.getCategory($route.current.params.id);
			},
			associates: function(associatesAPI, $route){
				return associatesAPI.getAssociates().then(function(response){
					response.data = response.data.filter(function(associate){
						return associate.categoryId == $route.current.params.id;
					});
					return response;
				});
			}
		}
	});
	$routeProvider.when(_managerBase+"/categories/:categoryId/new_associate",{
		templateUrl: "manager/view/associateNew.html",
		controller: "associateNewCtrl",
		resolve: {
			category: function(categoriesAPI, $route){
				return categoriesAPI.getCategory($route.current.params.categoryId);
			}
		}
	});
	$routeProvider.when(_managerBase+"/categories/:categoryId/:associateId",{
		templateUrl: "manager/view/associateDetails.html",
		controller: "associateDetailsCtrl",
		resolve: {
			associate: function(associatesAPI, $route){
				return associatesAPI.getAssociate($route.current.params.associateId);
			},
			category: function(categoriesAPI, $route){
				return categoriesAPI.getCategory($route.current.params.categoryId);
			}
		}
	});







	$routeProvider.when(_managerBase+"/events", {
		templateUrl: "manager/view/events.html",
		controller: "eventsCtrl",
		resolve: {
			events: function (eventsAPI){
				return eventsAPI.getEvents();
			}
		}
	});
	$routeProvider.when(_managerBase+"/events/new_event", {
		templateUrl: "manager/view/eventNew.html",
		controller: "eventNewCtrl"
	});
	$routeProvider.when(_managerBase+"/events/:id", {
		templateUrl: "manager/view/eventDetails.html",
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
	$routeProvider.when(_managerBase+"/events/:eventId/new_activity",{
		templateUrl: "manager/view/activityNew.html",
		controller: "activityNewCtrl",
		resolve: {
			event: function(eventsAPI, $route){
				return eventsAPI.getEvent($route.current.params.eventId);
			}
		}
	});
	$routeProvider.when(_managerBase+"/events/:eventId/:activityId",{
		templateUrl: "manager/view/activityDetails.html",
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





	$routeProvider.when(_managerBase+"/professions", {
		templateUrl: "manager/view/professions.html",
		controller: "professionsCtrl",
		resolve: {
			professions: function (professionsAPI){
				return professionsAPI.getProfessions();
			}
		}
	});
	$routeProvider.when(_managerBase+"/professions/new_profession", {
		templateUrl: "manager/view/professionNew.html",
		controller: "professionNewCtrl"
	});
	$routeProvider.when(_managerBase+"/professions/:id", {
		templateUrl: "manager/view/professionDetails.html",
		controller: "professionDetailsCtrl",
		resolve: {
			profession: function (professionsAPI, $route){
				return professionsAPI.getProfession($route.current.params.id);
			}
		}
	});


	$routeProvider.otherwise({redirectTo:"/"});
});