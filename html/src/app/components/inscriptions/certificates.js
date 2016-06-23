System.register(['angular2/core', '../rd-loading/rd-loading', '../rd-widget/rd-widget', '../../services/certificate/certificate-service', '../../domain/certificate/certificate'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, rd_loading_1, rd_widget_1, certificate_service_1, certificate_1;
    var Certificates;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (rd_loading_1_1) {
                rd_loading_1 = rd_loading_1_1;
            },
            function (rd_widget_1_1) {
                rd_widget_1 = rd_widget_1_1;
            },
            function (certificate_service_1_1) {
                certificate_service_1 = certificate_service_1_1;
            },
            function (certificate_1_1) {
                certificate_1 = certificate_1_1;
            }],
        execute: function() {
            Certificates = (function () {
                function Certificates(_service) {
                    this._service = _service;
                    this.certificates = [];
                }
                Certificates.prototype.ngOnInit = function () {
                    var _this = this;
                    this._service.getList()
                        .subscribe(function (data) { return _this.certificates = data; }, function (error) { return console.log(error); });
                };
                Certificates.prototype.onAdd = function () {
                    this.domain = new certificate_1.certificate();
                    return false;
                };
                Certificates.prototype.onBack = function () {
                    this.domain = null;
                    return false;
                };
                Certificates.prototype.onSave = function () {
                    this._service.save(this.domain);
                    return false;
                };
                Certificates = __decorate([
                    core_1.Component({
                        selector: 'certificates',
                        templateUrl: 'app/components/certificates/certificates.html',
                        directives: [rd_widget_1.RdWidget, rd_loading_1.RdLoading]
                    }), 
                    __metadata('design:paramtypes', [certificate_service_1.CertificateService])
                ], Certificates);
                return Certificates;
            }());
            exports_1("Certificates", Certificates);
        }
    }
});
//# sourceMappingURL=certificates.js.map