angular.module("eventex").directive("uiDate", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatDate = function (date) {
				date = date.replace(/[^0-9]+/g,"");
				if(date.length > 4){
					date = date.substring(0,4) + "/" + date.substring(4,8);
				}
				if(date.length > 2){
					date = date.substring(0,2) + "/" + date.substring(2);
				}
				return date;
			}
			element.bind("keyup", function(){
				if(ctrl.$dirty){
					ctrl.$setViewValue(_formatDate(ctrl.$viewValue));
					ctrl.$render();
				}
			});

			ctrl.$parsers.push(function (value){
				if(value.length === 10){
					var _dateArray = value.split("/");
					return new Date(_dateArray[2],_dateArray[1]-1,_dateArray[0]);
				}
			})
		}
	};
});