angular.module("eventex").service("modal", function ($modal){
    return function(templateUrl,controller,data){
        return $modal.open({
            backdrop: 'static',
            templateUrl: templateUrl,
            controller: controller,
            resolve:{
            	data:data
            }
            }).result.then(function(result){
                return result;
            });
    };
});