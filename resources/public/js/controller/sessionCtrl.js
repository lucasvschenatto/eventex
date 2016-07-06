angular.module('eventex').controller('sessionCtrl', function ($scope, modal, $state) {
    $scope.logout = function () {
        console.log("logout");
    };
    $scope.login = function () {
        console.log("login");
    };
});