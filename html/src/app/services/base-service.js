System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var BaseService;
    return {
        setters:[],
        execute: function() {
            BaseService = (function () {
                function BaseService() {
                    this._baseUrl = "http://eventex.herokuapp.com";
                }
                return BaseService;
            }());
            exports_1("BaseService", BaseService);
        }
    }
});
//# sourceMappingURL=base-service.js.map