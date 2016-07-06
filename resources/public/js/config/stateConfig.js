angular.module('eventex').config(function ($stateProvider, $urlRouterProvider, $httpProvider) {
    var _managerBase = "";
    $stateProvider
        .state("register", {
            url: "/register",
            templateUrl: "view/register.html",
            controller: "registerCtrl"
        })
        .state("adminValidation",{
            abstract: true,
        })
        .state("dashboard",{
            url: _managerBase,
            templateUrl: "manager/view/dashboard.html"
        })

        .state("activityFilter",{
            abstract: true,
            url: _managerBase,
            template: "<ui-view/>",
            resolve: {
                activity : function(modal){
                    return modal('manager/view/activityFilter.html','activityFilterCtrl');
                }
            }
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
        .state("categoryFilter",{
            abstract: true,
            url: _managerBase,
            template: "<ui-view/>",
            resolve: {
                category: function(modal){
                    return modal('manager/view/categoryFilter.html','categoryFilterCtrl');
                }
            }
        })

        .state("admins",{
            url: _managerBase+"/admins",
            templateUrl: "manager/view/admins.html",
            controller: "adminsCtrl"
        })
        
        .state("activities",{
            parent: "eventFilter",
            url: "/activities",
            templateUrl: "manager/view/activities.html",
            controller: "activitiesCtrl"
        })
        
        
        .state("associates",{
            parent: "categoryFilter",
            url: "/associates",
            templateUrl: "manager/view/associates.html",
            controller: "associatesCtrl"
        })

        .state("categories",{
            url: _managerBase+"/categories",
            templateUrl: "manager/view/categories.html",
            controller: "categoriesCtrl",
            resolve: {
                categories: function (categoriesAPI){
                    return categoriesAPI.getAll();
                }
            }
        })
        .state("events",{
            url: _managerBase+"/events",
            templateUrl: "manager/view/events.html",
            controller: "eventsCtrl",
            resolve: {
                events: function (eventsAPI){
                    return eventsAPI.getAll();
                }
            }
        })
        .state("inscriptions",{
            parent: "activityFilter",
            url: "/inscriptions",
            templateUrl: "manager/view/inscriptions.html",
            controller: "inscriptionsCtrl"
        })
        .state("participants",{
            url: _managerBase+"/participants",
            templateUrl: "manager/view/participants.html",
            controller: "participantsCtrl",
            resolve: {
                participants: function (participantsAPI){
                    return participantsAPI.getAll();
                }
            }
        })
        .state("professions",{
            url: _managerBase+"/professions",
            templateUrl: "manager/view/professions.html",
            controller: "professionsCtrl"
        });
    $urlRouterProvider.otherwise('/');    
});