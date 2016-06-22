import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {ActivityService} from '../../services/activity/activity-service';
import {activity} from '../../domain/activity/activity';

@Component({
    selector: 'activities',
    templateUrl: 'app/components/activities/activities.html',
    directives: [RdWidget, RdLoading]
})
export class Activities implements OnInit {
    public domain: activity;
    public activities: activity[] = [];

    constructor(private _service: ActivityService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.activities = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new activity();

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
