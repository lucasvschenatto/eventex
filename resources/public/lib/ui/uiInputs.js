angular.module("ui").factory("uiInputAPI", function (){
	var _makeField = function(required, editMode, help, label, placeholder, type){
		return {
	    	editMode: editMode,
	    	help: help, 
			label: label,
			placeholder: placeholder,
			required: required? "Campo obrigatório":"",
			type: type
		};
	};
	return {
		makeField:_makeField
	};
});

angular.module("ui").directive("uiSelect",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/select.html",
		scope: {
			field: "=",
			status: "=",
			options: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiSelectId",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/selectId.html",
		scope: {
			field: "=",
			status: "=",
			options: "=",
			model: "=ngModel"
		}
	};
	return _directive;
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
angular.module("ui").directive("uiInputAddress",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputAddress.html",
		scope: {
			title: "@",
			field: "=",
			editMode: "=",
			status: "=",
			address: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputNumber",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputNumber.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputDuration",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputDuration.html",
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
angular.module("ui").directive("uiInputDateOld",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputDateOld.html",
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
angular.module("ui").directive("uiInputTime",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputTime.html",
		scope: {
			field: "=",
			status: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});
angular.module("ui").directive("uiInputCheck",function(){
	var _directive = {
		templateUrl: "/lib/ui/view/inputCheck.html",
		scope: {
			field: "=",
			model: "=ngModel"
		}
	};
	return _directive;
});