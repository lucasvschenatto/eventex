// import 'core-js';
// import 'zone.js';

import {Component, bind} from 'angular2/core';
import {bootstrap} from 'angular2/platform/browser';
import {HTTP_PROVIDERS} from 'angular2/http';
import {FORM_PROVIDERS} from 'angular2/common';

import {provide} from 'angular2/core';
import {HashLocationStrategy, LocationStrategy} from 'angular2/platform/common';

import {
    RouteConfig,
    ROUTER_DIRECTIVES,
    ROUTER_PROVIDERS
} from 'angular2/router';

import {Dashboard} from './components/dashboard/dashboard';

import {UserListService} from './services/user_list';
import {ServerListService} from './services/server_list';

import {Events} from './components/events/events';
import {EventService} from './services/event/event-service';

import {Activities} from "./components/activities/activities";
import {ActivityService} from "./services/activity/activity-service";

import {Associates} from "./components/associates/associates";
import {AssociateService} from "./services/associate/associate-service";

import {Categories} from "./components/categories/categories";
import {CategoryService} from "./services/category/category-service";

import {Certificates} from "./components/certificates/certificates";
import {CertificateService} from "./services/certificate/certificate-service";

import {Inscriptions} from "./components/inscriptions/inscriptions";
import {InscriptionService} from "./services/inscription/inscription-service";

import {Participants} from "./components/participants/participants";
import {ParticipantService} from "./services/participant/participant-service";

export declare const REST_URL:string = "http://localhost:8080";

@RouteConfig([
    {path: '/', component: Dashboard, name: 'Dashboard'},
    {path: '/events', component: Events, name: 'Events'},
    {path: '/activities', component: Activities, name: 'Activities'},
    {path: '/associates', component: Associates, name: 'Associates'},
    {path: '/categories', component: Categories, name: 'Categories'},
    {path: '/certificates', component: Certificates, name: 'Certificates'},
    {path: '/inscriptions', component: Inscriptions, name: 'Inscriptions'},
    {path: '/participants', component: Participants, name: 'Participants'}
])
@Component({
    selector: 'app',
    templateUrl: 'app/main.html',
    styleUrls: ['app/main.css'],
    directives: [ROUTER_DIRECTIVES]
})
class Main {

    mobileView:number = 992;
    toggle:boolean = false;

    constructor() {
        this.attachEvents();
    }

    attachEvents() {
        window.onresize = ()=> {
            if (this.getWidth() >= this.mobileView) {
                if (localStorage.getItem('toggle')) {
                    this.toggle = !localStorage.getItem('toggle') ? false : true;
                } else {
                    this.toggle = true;
                }
            } else {
                this.toggle = false;
            }
        }
    }

    getWidth() {
        return window.innerWidth;
    }

    toggleSidebar() {
        this.toggle = !this.toggle;
        localStorage.setItem('toggle', this.toggle.toString());
    }
}

bootstrap(Main, [ROUTER_PROVIDERS, provide(LocationStrategy, {useClass: HashLocationStrategy}),
    FORM_PROVIDERS, HTTP_PROVIDERS, UserListService, ServerListService,
    EventService, ActivityService, AssociateService, CategoryService, CertificateService, InscriptionService,
    ParticipantService]);
