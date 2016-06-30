angular.module("ui",[]);

angular.module("ui").run(function ($templateCache){
	$templateCache.put("view/accordion.html",
		"<div class='ui-accordion-title' ng-click='open()'>{{title}}</div>"
		+"<div class='ui-accordion-content' ng-show='isOpened' ng-transclude></div>");
	$templateCache.put("view/input.html",
		"<div class='form-group {{status}}'>"+
        	"<label class='col-sm-2 control-label' for='input'>{{label}} {{model}}</label>"+
        	"<div class='col-sm-10'>"+
            	"<input class='form-control' type='text' id='input' ng-model='model' placeholder='{{placeholder}}' ng-disabled='{{disabled}}'>"+
            	"<span class='help-block'>{{help}}</span>"+
        	"</div>"+
   		"</div>"
		);
});
angular.module("ui").directive("uiAccordions",function(){
	return{
		controller: function($scope, $element, $attrs){
			var accordions = [];

			this.registerAccordion = function (accordion){
				accordions.push(accordion);
			};
			this.closeAll = function(){
				accordions.forEach(function (accordion){
					accordion.isOpened = false;
				});
			}
		}
	};
});
angular.module("ui").directive("uiAccordion",function(){
	return{
		templateUrl: "view/accordion.html",
		transclude: true,
		scope: {
			title: "@"
		},
		require: '^uiAccordions',
		link: function(scope, element, attrs, ctrl){
			ctrl.registerAccordion(scope);
			scope.open = function(){
				var oldState = this.isOpened;
				ctrl.closeAll();
				this.isOpened = !oldState;
			};
		}
	};
});
angular.module("ui").directive("uiInput",function(){
	return{
		templateUrl: "view/input.html",
		scope: {
			disabled: "=",
			help: "@",
			label: "@",
			model: "=",
			placeholder: "@",
			status: "="
		}
	};
});