/**
 * Created by Sandip on 7/9/16.
 */

'use strict';

/* Controllers */
// signin controller
app.controller('LoginFormController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.login = function() {
    $scope.authError = null;
        // Try to login
        console.log("LoginFormController")
        console.log($scope.user)
        $http.post('/login', {
            user:{
                username: $scope.user.email,
                password: $scope.user.password
        } })
            .then(function(response) {
                if ( !response.data ) {
                    $scope.authError = 'Email or Password not right';
                }else{
                    console.log(angular.toJson(response.data))
                    $state.go('openmart.home');
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });
    };
}])
;
