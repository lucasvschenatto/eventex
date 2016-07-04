angular.module("ui").directive("uiTable", function(){
	var _directive = {
		templateUrl: "/lib/ui/view/table.html",
		scope: {
			columns: "=",
			values: "=",
			state: "@"
		}
	};
	return _directive;
});