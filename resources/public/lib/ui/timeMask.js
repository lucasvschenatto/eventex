angular.module("ui").directive("uiMaskTime", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatTime = function (date) {
				date = date.replace(/[^0-9]+/g,"");
				if(date.length > 2){
					date = date.substring(0,2) + ":" + date.substring(2,4);
				}
				return date;
			}
			element.bind("keyup", function(){
				if(ctrl.$dirty){
					ctrl.$setViewValue(_formatTime(ctrl.$viewValue));
					ctrl.$render();
				}
			});
		}
	};
});