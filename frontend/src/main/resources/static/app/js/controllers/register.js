'use strict';

// signup controller
app.controller('RegisterFormController', ['$rootScope','$scope', '$http', '$state', 'AclService', function($rootScope,$scope, $http, $state,AclService) {
    $scope.user = {};
    $scope.authError = null;
    $scope.can = AclService.can;
    $scope.register = function() {
      $scope.authError = null;
      // Try to create
        var data =
            {
                name: $scope.user.name,
                username: $scope.user.email,
                password: $scope.user.password
            }
        console.log(data)
        $http.post('http://localhost:8090/openmart/api/user/register',data)
            .then(function(response) {
                if ( !response.data ) {
                    $scope.authError = 'Email or Password not right';
                }else{
                    console.log(angular.toJson(response.data))
                    $rootScope.loggedUser=response.data
                    $state.go('openmart.home');
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });




    };
  }])
 ;