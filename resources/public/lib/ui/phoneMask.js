angular.module("ui").directive("uiMaskPhone", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatTelephone = function (tel) {
				tel = tel.replace(/[^0-9]+/g,"");
				if(tel.length > 6){
					tel = tel.substring(0,6) + "-" + tel.substring(6,10);
				}
				if(tel.length > 2){
					tel = tel.substring(0,2) + ") " + tel.substring(2);
				}
				if(tel.length > 0){
					tel = "(" + tel;
				}
				return tel;
			}
			element.bind("keyup", function(){
				if(ctrl.$dirty){
					console.log(ctrl);
					ctrl.$setViewValue(_formatTelephone(ctrl.$viewValue));
					ctrl.$render();
				}
			});
		}
	};
});