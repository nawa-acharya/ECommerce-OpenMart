/**
 * Created by Sandip on 7/9/16.
 */

'use strict';

/* Controllers */
// signin controller
app.controller('LoginFormController', ['$rootScope','$scope', '$http', '$state', function($rootScope,$scope, $http, $state,$stateParams) {
    $scope.user = {};

    $scope.authError = null;
    $scope.login = function() {
    $scope.authError = null;
        // Try to login
        $http.post('http://localhost:8090/openmart/api/user/login', {
                username: $scope.user.email,
                password: $scope.user.password
        } )
            .then(function(response) {
                if ( !response.data ) {
                    $scope.authError = 'Email or Password not right';
                }else{
                    console.log(angular.toJson(response.data))
                    $rootScope.loggedUser=response.data
                    $state.go('openmart.home.profile');
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });

        //$http.get('http://localhost:8090/openmart/api/product/list')
        //    .then(function(response) {
        //        if ( !response.data ) {
        //            $scope.authError = 'Email or Password not right';
        //        }else{
        //            console.log(angular.toJson(response.data))
        //            $state.go('openmart.home');
        //        }
        //    }, function(x) {
        //        $scope.authError = 'Server Error';
        //    });
    };
}]);





