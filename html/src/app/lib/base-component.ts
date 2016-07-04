import {Component, OnInit} from 'angular2/core';
import {BaseService} from "./base-service";

export class BaseComponent implements OnInit {
    protected _service: BaseService;
    private _list:any;

    ngOnInit() {
        this._list = this._service.getList();
        this.subscribe();
    }
}