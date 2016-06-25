angular.module("eventex").directive("uiCpf", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatCPF = function (cpf) {
				cpf = cpf.replace(/[^0-9]+/g,"");
				if(cpf.length > 9){
					cpf = cpf.substring(0,9) + "-" + cpf.substring(9,11);
				}
				if(cpf.length > 6){
					cpf = cpf.substring(0,6) + "." + cpf.substring(6);
				}
				if(cpf.length > 3){
					cpf = cpf.substring(0,3) + "." + cpf.substring(3);
				}
				return cpf;
			}
			element.bind("keyup", function(){
				ctrl.$setViewValue(_formatCPF(ctrl.$viewValue));
				ctrl.$render();
			});
		}
	};
});