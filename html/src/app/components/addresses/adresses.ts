import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {AddressService} from '../../services/address/address-service';
import {address} from '../../domain/address/address';

@Component({
    selector: 'addresses',
    templateUrl: 'app/components/addresses/addresses.html',
    directives: [RdWidget, RdLoading]
})
export class Addresses implements OnInit {
    public domain: address;
    public addresses: address[] = [];

    constructor(private _service: AddressService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.addresses = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new address();

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
