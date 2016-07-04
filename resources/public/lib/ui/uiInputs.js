angular.module("ui").factory("uiInputAPI", function (){
	var _makeField = function(required, disabled, help, label, placeholder, type){
		return {
	    	disabled: disabled,
	    	help: help, 
			label: label,
			placeholder: placeholder,
			required: required? "Campo obrigatório":"",
			type: type
		};
	};
	return {
		makeField: _makeField,
	};
});



angular.module("ui").directive("uiInput",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/input.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputCep",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputCep.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputCnpj",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputCnpj.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputCpf",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputCpf.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputDate",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputDate.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputPhone",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputPhone.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});