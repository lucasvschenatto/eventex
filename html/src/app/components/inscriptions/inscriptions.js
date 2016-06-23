System.register(['angular2/core', '../rd-loading/rd-loading', '../rd-widget/rd-widget', '../../services/inscription/inscription-service', '../../domain/inscription/inscription'], function(exports_1, context_1) {
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
    var core_1, rd_loading_1, rd_widget_1, inscription_service_1, inscription_1;
    var Inscriptions;
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
            function (inscription_service_1_1) {
                inscription_service_1 = inscription_service_1_1;
            },
            function (inscription_1_1) {
                inscription_1 = inscription_1_1;
            }],
        execute: function() {
            Inscriptions = (function () {
                function Inscriptions(_service) {
                    this._service = _service;
                    this.inscriptions = [];
                }
                Inscriptions.prototype.ngOnInit = function () {
                    var _this = this;
                    this._service.getList()
                        .subscribe(function (data) { return _this.inscriptions = data; }, function (error) { return console.log(error); });
                };
                Inscriptions.prototype.onAdd = function () {
                    this.domain = new inscription_1.inscription();
                    return false;
                };
                Inscriptions.prototype.onBack = function () {
                    this.domain = null;
                    return false;
                };
                Inscriptions.prototype.onSave = function () {
                    this._service.save(this.domain);
                    return false;
                };
                Inscriptions = __decorate([
                    core_1.Component({
                        selector: 'inscriptions',
                        templateUrl: 'app/components/inscriptions/inscriptions.html',
                        directives: [rd_widget_1.RdWidget, rd_loading_1.RdLoading]
                    }), 
                    __metadata('design:paramtypes', [inscription_service_1.InscriptionService])
                ], Inscriptions);
                return Inscriptions;
            }());
            exports_1("Inscriptions", Inscriptions);
        }
    }
});
//# sourceMappingURL=inscriptions.js.map