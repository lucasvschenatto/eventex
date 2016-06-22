import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {InscriptionService} from '../../services/inscription/inscription-service';
import {inscription} from '../../domain/inscription/inscription';

@Component({
    selector: 'inscriptions',
    templateUrl: 'app/components/inscriptions/inscriptions.html',
    directives: [RdWidget, RdLoading]
})
export class Inscriptions implements OnInit {
    public domain: inscription;
    public inscriptions: inscription[] = [];

    constructor(private _service: InscriptionService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.inscriptions = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new inscription();

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
