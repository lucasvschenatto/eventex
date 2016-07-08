angular.module("ui").directive("uiMaskDuration", function(){
	return {
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			var _formatDuration = function (duration) {
				duration = duration.replace(/[^0-9]+/g,"");
				if(duration.length > 2)
					duration = duration.substring(0,2) + ":" + duration.substring(2,4);
				return duration;
			}
			element.bind("keyup", function(){
				if(ctrl.$dirty){
					ctrl.$setViewValue(_formatDuration(ctrl.$viewValue));
					ctrl.$render();
				}
			});

			ctrl.$parsers.push(function (value){
				if(value.length === 5){
					var _timeArray = value.split(":");
					var _duration = _timeArray[0]*60 + _timeArray[1];
					console.log(_duration);
					return _duration;
				}
			})
		}
	};
});