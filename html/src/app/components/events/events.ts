import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {EventService} from '../../services/event/event-service';
import {Event} from '../../domain/event/event';
import {address} from '../../domain/address/address';

@Component({
    selector: 'events',
    templateUrl: 'app/components/events/events.html',
    directives: [RdWidget, RdLoading]
})
export class Events implements OnInit {
    public domain: Event;
    public events: Event[] = [];

    constructor(private _service:EventService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.events = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new Event();
        this.domain.address = new address();

        return false;
    }

    public onBack(): boolean {
        this.domain = null;

        return false;
    }

    public onSave(): boolean {
        this._service.save(this.domain);

        return false;
    }
}
