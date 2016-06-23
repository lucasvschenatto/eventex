System.register(['angular2/core', '../rd-loading/rd-loading', '../rd-widget/rd-widget', '../../services/address/address-service', '../../domain/address/address'], function(exports_1, context_1) {
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
    var core_1, rd_loading_1, rd_widget_1, address_service_1, address_1;
    var Addresses;
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
            function (address_service_1_1) {
                address_service_1 = address_service_1_1;
            },
            function (address_1_1) {
                address_1 = address_1_1;
            }],
        execute: function() {
            Addresses = (function () {
                function Addresses(_service) {
                    this._service = _service;
                    this.addresses = [];
                }
                Addresses.prototype.ngOnInit = function () {
                    var _this = this;
                    this._service.getList()
                        .subscribe(function (data) { return _this.addresses = data; }, function (error) { return console.log(error); });
                };
                Addresses.prototype.onAdd = function () {
                    this.domain = new address_1.address();
                    return false;
                };
                Addresses.prototype.onBack = function () {
                    this.domain = null;
                    return false;
                };
                Addresses.prototype.onSave = function () {
                    this._service.save(this.domain);
                    return false;
                };
                Addresses = __decorate([
                    core_1.Component({
                        selector: 'addresses',
                        templateUrl: 'app/components/addresses/addresses.html',
                        directives: [rd_widget_1.RdWidget, rd_loading_1.RdLoading]
                    }), 
                    __metadata('design:paramtypes', [address_service_1.AddressService])
                ], Addresses);
                return Addresses;
            }());
            exports_1("Addresses", Addresses);
        }
    }
});
//# sourceMappingURL=adresses.js.map