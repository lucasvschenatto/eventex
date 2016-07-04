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
    .state("eventFilter",{
        resolve: {
            eventId : function(eventsAPI){
                return "";
            }
        }
    })
    .state("eventFilter.activities",{
        url: _managerBase+"/activities",
        templateUrl: "manager/view/activities.html",
        controller: "activitiesCtrl",
        resolve: {
            activities: function(activitiesAPI, eventId){
                return activitiesAPI.getActivitiesFilteredByEvent(eventId);
            }
        }
    })
    .state()

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
    }).state("categories.details",{
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


        // .state('loadingSession', {
        //     url: '/',
        //     templateUrl: '/loading.html',
        //     controller: 'loadSessionController'
        // })
        // .state('register', {
        //     url: '/register',
        //     templateUrl: '/account/register.html',
        //     controller: 'registerController',
        //     data: {logInRequired: false}
        // })
        // .state('webStore', {
        //     url: '/webStore',
        //     templateUrl: '/webStore.html',
        //     data: {logInRequired: true}
        // })
        // .state('webStore.orders', {
        //     url: '/orders',
        //     templateUrl: '/order/underConstruction.html'
        // })
        // .state('webStore.products', {
        //     url: '/products',
        //     templateUrl: '/product/list.html',
        //     controller: 'productsController'
        // })
        // .state('webStore.createProduct', {
        //     url: '/products/create',
        //     templateUrl: '/product/create.html',
        //     controller: 'createProductController'
        // });
    
});