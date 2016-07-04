angular.module("ui").directive("uiBlock", function(){
	var _directive = {
		templateUrl: "/lib/ui/view/block.html",
		scope: {
			icon: "@",
			name: "@",
			color: "@",
			state: "@"
		}
	};
	return _directive;
});