// import 'core-js';
// import 'zone.js';
System.register(['angular2/core', 'angular2/platform/browser', 'angular2/http', 'angular2/common', 'angular2/platform/common', 'angular2/router', './components/dashboard/dashboard', './services/user_list', './services/server_list', './components/events/events', './services/event/event-service', "./components/activities/activities", "./services/activity/activity-service", "./components/associates/associates", "./services/associate/associate-service", "./components/categories/categories", "./services/category/category-service", "./components/certificates/certificates", "./services/certificate/certificate-service", "./components/inscriptions/inscriptions", "./services/inscription/inscription-service", "./components/participants/participants", "./services/participant/participant-service"], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, browser_1, http_1, common_1, core_2, common_2, router_1, dashboard_1, user_list_1, server_list_1, events_1, event_service_1, activities_1, activity_service_1, associates_1, associate_service_1, categories_1, category_service_1, certificates_1, certificate_service_1, inscriptions_1, inscription_service_1, participants_1, participant_service_1;
    var Main;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
                core_2 = core_1_1;
            },
            function (browser_1_1) {
                browser_1 = browser_1_1;
            },
            function (http_1_1) {
                http_1 = http_1_1;
            },
            function (common_1_1) {
                common_1 = common_1_1;
            },
            function (common_2_1) {
                common_2 = common_2_1;
            },
            function (router_1_1) {
                router_1 = router_1_1;
            },
            function (dashboard_1_1) {
                dashboard_1 = dashboard_1_1;
            },
            function (user_list_1_1) {
                user_list_1 = user_list_1_1;
            },
            function (server_list_1_1) {
                server_list_1 = server_list_1_1;
            },
            function (events_1_1) {
                events_1 = events_1_1;
            },
            function (event_service_1_1) {
                event_service_1 = event_service_1_1;
            },
            function (activities_1_1) {
                activities_1 = activities_1_1;
            },
            function (activity_service_1_1) {
                activity_service_1 = activity_service_1_1;
            },
            function (associates_1_1) {
                associates_1 = associates_1_1;
            },
            function (associate_service_1_1) {
                associate_service_1 = associate_service_1_1;
            },
            function (categories_1_1) {
                categories_1 = categories_1_1;
            },
            function (category_service_1_1) {
                category_service_1 = category_service_1_1;
            },
            function (certificates_1_1) {
                certificates_1 = certificates_1_1;
            },
            function (certificate_service_1_1) {
                certificate_service_1 = certificate_service_1_1;
            },
            function (inscriptions_1_1) {
                inscriptions_1 = inscriptions_1_1;
            },
            function (inscription_service_1_1) {
                inscription_service_1 = inscription_service_1_1;
            },
            function (participants_1_1) {
                participants_1 = participants_1_1;
            },
            function (participant_service_1_1) {
                participant_service_1 = participant_service_1_1;
            }],
        execute: function() {
            Main = (function () {
                function Main() {
                    this.mobileView = 992;
                    this.toggle = false;
                    this.attachEvents();
                }
                Main.prototype.attachEvents = function () {
                    var _this = this;
                    window.onresize = function () {
                        if (_this.getWidth() >= _this.mobileView) {
                            if (localStorage.getItem('toggle')) {
                                _this.toggle = !localStorage.getItem('toggle') ? false : true;
                            }
                            else {
                                _this.toggle = true;
                            }
                        }
                        else {
                            _this.toggle = false;
                        }
                    };
                };
                Main.prototype.getWidth = function () {
                    return window.innerWidth;
                };
                Main.prototype.toggleSidebar = function () {
                    this.toggle = !this.toggle;
                    localStorage.setItem('toggle', this.toggle.toString());
                };
                Main = __decorate([
                    router_1.RouteConfig([
                        { path: '/', component: dashboard_1.Dashboard, name: 'Dashboard' },
                        { path: '/events', component: events_1.Events, name: 'Events' },
                        { path: '/activities', component: activities_1.Activities, name: 'Activities' },
                        { path: '/associates', component: associates_1.Associates, name: 'Associates' },
                        { path: '/categories', component: categories_1.Categories, name: 'Categories' },
                        { path: '/certificates', component: certificates_1.Certificates, name: 'Certificates' },
                        { path: '/inscriptions', component: inscriptions_1.Inscriptions, name: 'Inscriptions' },
                        { path: '/participants', component: participants_1.Participants, name: 'Participants' }
                    ]),
                    core_1.Component({
                        selector: 'app',
                        templateUrl: 'app/main.html',
                        styleUrls: ['app/main.css'],
                        directives: [router_1.ROUTER_DIRECTIVES]
                    }), 
                    __metadata('design:paramtypes', [])
                ], Main);
                return Main;
            }());
            browser_1.bootstrap(Main, [router_1.ROUTER_PROVIDERS, core_2.provide(common_2.LocationStrategy, { useClass: common_2.HashLocationStrategy }),
                common_1.FORM_PROVIDERS, http_1.HTTP_PROVIDERS, user_list_1.UserListService, server_list_1.ServerListService,
                event_service_1.EventService, activity_service_1.ActivityService, associate_service_1.AssociateService, category_service_1.CategoryService, certificate_service_1.CertificateService, inscription_service_1.InscriptionService,
                participant_service_1.ParticipantService]);
        }
    }
});
//# sourceMappingURL=main.js.map