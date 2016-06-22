import {Component, OnInit} from 'angular2/core';

import {RdLoading} from '../rd-loading/rd-loading';
import {RdWidget} from '../rd-widget/rd-widget';

import {CertificateService} from '../../services/certificate/certificate-service';
import {certificate} from '../../domain/certificate/certificate';

@Component({
    selector: 'certificates',
    templateUrl: 'app/components/certificates/certificates.html',
    directives: [RdWidget, RdLoading]
})
export class Certificates implements OnInit {
    public domain: certificate;
    public certificates: certificate[] = [];

    constructor(private _service: CertificateService) {
    }

    ngOnInit() {
        this._service.getList()
            .subscribe(data => this.certificates = data, error => console.log(error));
    }

    public onAdd(): boolean {
        this.domain = new certificate();

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
