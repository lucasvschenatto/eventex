System.register(["rxjs/Observable", "angular2/core"], function(exports_1, context_1) {
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
    var Observable_1, core_1;
    var BaseService;
    return {
        setters:[
            function (Observable_1_1) {
                Observable_1 = Observable_1_1;
            },
            function (core_1_1) {
                core_1 = core_1_1;
            }],
        execute: function() {
            BaseService = (function () {
                function BaseService() {
                    this._baseUrl = "http://eventex.herokuapp.com";
                }
                BaseService.prototype.getList = function () {
                    return this._http.get(this._apiUrl)
                        .map(function (res) { return res.json(); })
                        .catch(this.throwError);
                };
                BaseService.prototype.save = function (domain) {
                    var body = JSON.stringify(domain);
                    return this._http.post(this._apiUrl, body)
                        .toPromise()
                        .then(function (res) { return res.json(); })
                        .catch(this.throwError);
                };
                BaseService.prototype.del = function (domain) {
                    return this._http.delete(this._apiUrl + "/" + domain.id)
                        .toPromise()
                        .catch(this.throwError);
                };
                BaseService.prototype.throwError = function (response) {
                    return Observable_1.Observable.throw(response.json().error || "Server error");
                };
                BaseService = __decorate([
                    core_1.Injectable(), 
                    __metadata('design:paramtypes', [])
                ], BaseService);
                return BaseService;
            }());
            exports_1("BaseService", BaseService);
        }
    }
});
//# sourceMappingURL=base-service.js.map