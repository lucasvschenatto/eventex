angular.module("ui").directive("uiMaskCnpj", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatCNPJ = function (cnpj) {
				cnpj = cnpj.replace(/[^0-9]+/g,"");
				if(cnpj.length > 12){
					cnpj = cnpj.substring(0,12) + "-" + cnpj.substring(12,14);
				}
				if(cnpj.length > 8){
					cnpj = cnpj.substring(0,8) + "/" + cnpj.substring(8);
				}
				if(cnpj.length > 5){
					cnpj = cnpj.substring(0,5) + "." + cnpj.substring(5);
				}
				if(cnpj.length > 2){
					cnpj = cnpj.substring(0,2) + "." + cnpj.substring(2);
				}
				return cnpj;
			}
			element.bind("keyup", function(){
				ctrl.$setViewValue(_formatCNPJ(ctrl.$viewValue));
				ctrl.$render();
			});
		}
	};
});