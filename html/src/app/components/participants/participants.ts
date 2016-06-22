import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {ParticipantService} from '../../services/participant/participant-service';
import {Participant} from '../../domain/participant/participant';

@Component({
    selector: 'participants',
    templateUrl: 'app/components/participants/participants.html',
    directives: [RdWidget, RdLoading]
})
export class Participants implements OnInit {
    public domain: Participant;
    public participants: Participant[] = [];

    constructor(private _service: ParticipantService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.participants = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new Participant();

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
