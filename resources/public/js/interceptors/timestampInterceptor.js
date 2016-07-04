angular.module("eventex").factory("timestampInterceptor", function(){
	return{
		request: function(config){
			var url = config.url;
			if (url.indexOf('.') > -1 || url.indexOf('?') > -1) return config;
			var timestamp = new Date().getTime();
			config.url = url + "?timestamp="+ timestamp;
			return config;
		}
	}
});