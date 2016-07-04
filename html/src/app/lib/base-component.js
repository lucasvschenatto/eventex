System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var BaseComponent;
    return {
        setters:[],
        execute: function() {
            BaseComponent = (function () {
                function BaseComponent() {
                }
                BaseComponent.prototype.ngOnInit = function () {
                    this._list = this._service.getList();
                    this.subscribe();
                };
                return BaseComponent;
            }());
            exports_1("BaseComponent", BaseComponent);
        }
    }
});
//# sourceMappingURL=base-component.js.map