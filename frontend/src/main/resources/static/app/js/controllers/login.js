/**
 * Created by Sandip on 7/9/16.
 */

'use strict';

/* Controllers */
// signin controller
app.controller('LoginFormController', ['$rootScope','$scope', '$http', '$state','AclService', function($rootScope,$scope, $http, $state,AclService) {
    $scope.user = {};
    $scope.can = AclService.can;
    $scope.authError = null;
    $scope.login = function() {
    $scope.authError = null;
     var data ={
         username: $scope.user.email,
         password: $scope.user.password
     };
        // Try to login
        $http.post('http://localhost:8090/openmart/api/user/login', data )
            .then(function(response) {
                if ( !response.data ) {
                    $scope.authError = 'Email or Password not right';
                }else{
                    $rootScope.loggedUser=response.data
                    console.log(response.data)
                    AclService.flushRoles();
                    for (var i = 0, len =  response.data.roles.length; i < len; i++) {
                        console.log($rootScope.loggedUser.roles[i])
                        AclService.attachRole($rootScope.loggedUser.roles[i].role);
                    }
                    $state.go('openmart.home.store');
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





