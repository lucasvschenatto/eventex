angular.module("ui").directive("uiMaskCep", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatCEP = function (cep) {
				cep = cep.replace(/[^0-9]+/g,"");
				if(cep.length > 5){
					cep = cep.substring(0,5) + "-" + cep.substring(5,8);
				}
				return cep;
			}
			element.bind("keyup", function(){
				ctrl.$setViewValue(_formatCEP(ctrl.$viewValue));
				ctrl.$render();
			});
		}
	};
});