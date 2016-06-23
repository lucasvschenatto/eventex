import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {RdWidgetHeader} from '../rd-widget-header/rd-widget-header';
import {RdWidgetBody} from '../rd-widget-body/rd-widget-body';
import {RdWidgetFooter} from '../rd-widget-footer/rd-widget-footer';

import {ServerListView} from '../server-list-view/server-list-view';
import {ServerListService} from '../../services/server_list';
import {UserListView} from '../user-list-view/user-list-view';

import {EventService} from '../../services/event/event-service';
import {Event} from '../../domain/event/event';
import {address} from '../../domain/address/address';
import {TEST_SERVER_APPLICATION_PROVIDERS} from "angular2/platform/testing/server";

/// <reference path="../../lib/bootbox.d.ts" />

@Component({
    selector: 'events',
    templateUrl: 'app/components/events/events.html',
    directives: [RdWidget, RdWidgetHeader, RdWidgetBody,
        RdWidgetFooter, RdLoading, ServerListView, UserListView]
})
export class Events implements OnInit {
    public domain: Event;
    public events: Event[] = [];
    private _list:any;

    constructor(private _service:EventService) {
    }

    ngOnInit() {
        this._list = this._service.getList();
        this.subscribe();
    }

    public subscribe(): void {
        this._list.subscribe(data => this.events = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new Event();
        this.domain.address = new address();

        return false;
    }

    public onEdit(current:Event): boolean {
        this.domain = new Event();
        this.domain = current;

        return false;
    }

    public onDel(current:Event): boolean {
        let service = this._service;
        let _this = this;
        bootbox.confirm("Você tem certeza que deseja excluir o evento selecionado?", function () {
            service.del(current);
            _this.subscribe();
        });
        return false;
    }

    public onBack(): boolean {
        this.domain = null;

        return false;
    }

    public onSave(): boolean {
        let response = this._service.save(this.domain);
        this.onBack();
        /*
        if(response.success) {
            this.onBack();
        } else {
            bootbox.alert("Ocorreu um erro inesperado. Por favor, contate o administrador do sistema.");
        }
         */
        return false;
    }
}
