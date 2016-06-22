import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {AssociateService} from '../../services/associate/associate-service';
import {associate} from '../../domain/associate/associate';

@Component({
    selector: 'associates',
    templateUrl: 'app/components/associates/associates.html',
    directives: [RdWidget, RdLoading]
})
export class Associates implements OnInit {
    public domain: associate;
    public associates: associate[] = [];

    constructor(private _service: AssociateService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.associates = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new associate();

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
