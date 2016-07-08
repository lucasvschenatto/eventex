angular.module("ui").directive("uiMaskNumber", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatNumber = function (number) {
				return number.replace(/[^0-9]+/g,"");
			}
			element.bind("keyup", function(){
				if(ctrl.$dirty){
					ctrl.$setViewValue(_formatNumber(ctrl.$viewValue));
					ctrl.$render();
				}
			});
		}
	};
});