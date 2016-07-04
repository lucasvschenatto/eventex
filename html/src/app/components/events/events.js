System.register(['angular2/core', '../rd-loading/rd-loading', '../rd-widget/rd-widget', '../rd-widget-header/rd-widget-header', '../rd-widget-body/rd-widget-body', '../rd-widget-footer/rd-widget-footer', '../../services/event/event-service', '../../domain/event/event', '../../domain/address/address'], function(exports_1, context_1) {
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
    var core_1, rd_loading_1, rd_widget_1, rd_widget_header_1, rd_widget_body_1, rd_widget_footer_1, event_service_1, event_1, address_1;
    var Events;
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
            function (rd_widget_header_1_1) {
                rd_widget_header_1 = rd_widget_header_1_1;
            },
            function (rd_widget_body_1_1) {
                rd_widget_body_1 = rd_widget_body_1_1;
            },
            function (rd_widget_footer_1_1) {
                rd_widget_footer_1 = rd_widget_footer_1_1;
            },
            function (event_service_1_1) {
                event_service_1 = event_service_1_1;
            },
            function (event_1_1) {
                event_1 = event_1_1;
            },
            function (address_1_1) {
                address_1 = address_1_1;
            }],
        execute: function() {
            /// <reference path="../../lib/bootbox.d.ts" />
            Events = (function () {
                function Events(_service) {
                    this._service = _service;
                    this.events = [];
                }
                Events.prototype.ngOnInit = function () {
                    this._list = this._service.getList();
                    this.subscribe();
                };
                Events.prototype.subscribe = function () {
                    var _this = this;
                    this._list.subscribe(function (data) { return _this.events = data; }, function (error) { return console.log(error); });
                };
                Events.prototype.onAdd = function () {
                    this.domain = new event_1.Event();
                    this.domain.address = new address_1.address();
                    return false;
                };
                Events.prototype.onEdit = function (current) {
                    this.domain = new event_1.Event();
                    this.domain = current;
                    return false;
                };
                Events.prototype.onDel = function (current) {
                    var service = this._service;
                    var _this = this;
                    bootbox.confirm({
                        message: "Você tem certeza que deseja excluir o evento selecionado?",
                        callback: function () {
                            service.del(current);
                            _this.subscribe();
                        }
                    });
                    return false;
                };
                Events.prototype.onBack = function () {
                    this.domain = null;
                    return false;
                };
                Events.prototype.onSave = function () {
                    var response = this._service.save(this.domain);
                    this.onBack();
                    /*
                    if(response.success) {
                        this.onBack();
                    } else {
                        bootbox.alert("Ocorreu um erro inesperado. Por favor, contate o administrador do sistema.");
                    }
                     */
                    return false;
                };
                Events = __decorate([
                    core_1.Component({
                        selector: 'events',
                        templateUrl: 'app/components/events/events.html',
                        directives: [rd_widget_1.RdWidget, rd_widget_header_1.RdWidgetHeader, rd_widget_body_1.RdWidgetBody,
                            rd_widget_footer_1.RdWidgetFooter, rd_loading_1.RdLoading]
                    }), 
                    __metadata('design:paramtypes', [event_service_1.EventService])
                ], Events);
                return Events;
            }());
            exports_1("Events", Events);
        }
    }
});
//# sourceMappingURL=events.js.map