angular.module("eventex").service("modal", function ($uibModal){
    return function(templateUrl,controller,data){
        return $uibModal.open({
            backdrop: 'static',
            templateUrl: templateUrl,
            controller: controller,
            resolve:{
            	data:data
            }
        })
        .result.then(function(result){
                return result;
        });
    };
});