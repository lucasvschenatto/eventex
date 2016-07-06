angular.module('eventex').controller('loadSessionController', function ($rootScope, $state, usersAPI) {
    userAPI.readUser().then(function (response) {
        $rootScope.loggedIn = response.data.success;
        if ($rootScope.loggedIn)
            $state.go('manager');
        else
            $state.go('register');
    });
});