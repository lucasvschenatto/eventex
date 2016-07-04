angular.module('eventex').config(function ($stateProvider, $urlRouterProvider, $httpProvider) {
    var _managerBase = "/manager";
    $stateProvider
        .state("register", {
            url: "/register",
            templateUrl: "view/register.html",
            controller: "registerCtrl"
        })
        .state("dashboard",{
            url: _managerBase,
            templateUrl: "manager/view/dashboard.html"
        })

        .state("admins",{
            url: _managerBase+"/admins",
            templateUrl: "manager/view/admins.html",
            controller: "adminsCtrl",
            resolve: {
                admins: function (adminsAPI){
                    return adminsAPI.getAdmins();
                }
            }
        })
        .state("admins.new",{
            url: "/new_admin",
            templateUrl: "manager/view/adminNew.html",
            controller: "adminNewCtrl"
        })
        
        .state("eventFilter",{
            abstract: true,
            url: _managerBase,
            template: "<ui-view/>",
            resolve: {
                event : function(modal){
                    return modal('manager/view/eventFilter.html','eventFilterCtrl');
                }
            }
        })
        .state("activities",{
            parent: "eventFilter",
            url: "/activities",
            templateUrl: "manager/view/activities.html",
            controller: "activitiesCtrl"
        })
        
        .state("categoryFilter",{
            url: _managerBase,
            resolve: {
                category: function(categoriesAPI){
                    return {id:"categoryId"};
                }
            }
        })
        .state("categoryFilter.associates",{
            url: "/associates",
            templateUrl: "manager/view/associates.html",
            controller: "associatesCtrl",
            resolve: {
                associates: function(associatesAPI, category){
                    return associatesAPI.getAssociatesFilteredByCategory(category.id);
                }
            }
        })
        .state("categoryFilter.associates.new",{
            url: "/new_associate",
            templateUrl: "manager/view/associateNew.html",
            controller: "associateNewController",
            resolve: {
                category: function(category){return category;}
            }
        })
        .state("categoryFilter.associates.details",{
            url: "/:id",
            templateUrl: "manager/view/associateDetails.html",
            controller: "associateDetailsCtrl",
            resolve: {
                associate: function(associatesAPI, $stateParams){
                    return associatesAPI.getAssociate($stateParams.id);
                },
                category: function(category){return category;}
            }
        })

        .state("categories",{
            url: _managerBase+"/categories",
            templateUrl: "manager/view/categories.html",
            controller: "categoriesCtrl",
            resolve: {
                categories: function (categoriesAPI){
                    return categoriesAPI.getCategories();
                }
            }
        }).state("categories.new",{
            url: "/new_category",
            templateUrl: "manager/view/categoryNew.html",
            controller: "categoryNewCtrl"
        })
        .state("categories.details",{
            url: "/:id",
            templateUrl: "manager/view/categoryDetails.html",
            controller: "categoryDetailsCtrl",
            resolve: {
                category: function (categoriesAPI, $stateParams){
                    return categoriesAPI.getCategory($stateParams.id);
                },
                associates: function(associatesAPI, $stateParams){
                    return associatesAPI.getAssociates().then(function(response){
                        response.data = response.data.filter(function(associate){
                            return associate.categoryId == $stateParams.id;
                        });
                        return response;
                    });
                }
            }
        })
        .state("events",{
            url: _managerBase+"/events",
            templateUrl: "manager/view/events.html",
            controller: "eventsCtrl",
            resolve: {
                events: function (eventsAPI){
                    return eventsAPI.getEvents();
                }
            }
        })
        .state("events.new",{
            url: "/new_event",
            templateUrl: "manager/view/eventNew.html",
            controller: "eventNewCtrl"
        })
        .state("events.details",{
            url: "/:id",
            templateUrl: "manager/view/eventDetails.html",
            controller: "eventDetailsCtrl",
            resolve: {
                event: function (eventsAPI, $stateParams){
                    return eventsAPI.getEvent($stateParams.id);
                },
                activities: function(activitiesAPI, $stateParams){
                    return activitiesAPI.getActivities().then(function(response){
                        response.data = response.data.filter(function(activity){
                            return activity.eventId == $stateParams.id;
                        });
                        return response;
                    });
                }
            }
        })
        .state("eventFilter.inscriptions",{
            url: "/inscriptions",
            templateUrl: "manager/view/inscriptions.html",
            controller: "inscriptionsCtrl",
            resolve: {
                inscriptions: function(inscriptionsAPI, event){
                    return inscriptionsAPI.getInscriptions();
                }
            }
        })
        .state("eventFilter.inscriptions.new",{
            url: "/new_inscriptions",
            templateUrl: "manager/view/inscriptionNew.html",
            controller: "inscriptionNewCtrl"
        })
        .state("eventFilter.inscriptions.details",{
            url: "/:id",
            templateUrl: "manager/view/inscriptionDetails.html",
            controller: "inscriptionDetailsCtrl",
            resolve: {
                inscription: function(inscriptionsAPI, $stateParams){
                    return inscriptionsAPI.getInscriptions($stateParams.id);
                }
            }
        })

        .state("participants",{
            url: _managerBase+"/participants",
            templateUrl: "manager/view/participants.html",
            controller: "participantsCtrl",
            resolve: {
                participants: function (participantsAPI){
                    return participantsAPI.getParticipants();
                }
            }
        })
        .state("participants.new",{
            url: "/new_participant",
            templateUrl: "manager/view/participantNew.html",
            controller: "participantNewCtrl"
        })
        .state("participants.details",{
            url: "/:id",
            templateUrl: "manager/view/participantDetails.html",
            controller: "participantDetailsCtrl",
            resolve: {
                participant: function (participantsAPI, $stateParams){
                    return participantsAPI.getParticipant($stateParams.id);
                }
            }
        })

        .state("professions",{
            url: _managerBase+"/professions",
            templateUrl: "manager/view/professions.html",
            controller: "professionsCtrl",
            resolve: {
                professions: function (professionsAPI){
                    return professionsAPI.getProfessions();
                }
            }
        })
        .state("professions.new",{
            url: "/new_profession",
            templateUrl: "manager/view/professionNew.html",
            controller: "professionNewCtrl"
        })
        .state("professions.details",{
            url: "/:id",
            templateUrl: "manager/view/professionDetails.html",
            controller: "professionDetailsCtrl",
            resolve: {
                profession: function (professionsAPI, $stateParams){
                    return professionsAPI.getProfession($stateParams.id);
                }
            }
        })

    $urlRouterProvider.otherwise('/');    
});