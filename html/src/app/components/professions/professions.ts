import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {ProfessionService} from '../../services/profession/profession-service';
import {profession} from '../../domain/profession/profession';

@Component({
    selector: 'professions',
    templateUrl: 'app/components/professions/professions.html',
    directives: [RdWidget, RdLoading]
})
export class Profession implements OnInit {
    public domain: profession;
    public professions: profession[] = [];

    constructor(private _service: ProfessionService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.professions = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new profession();

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
