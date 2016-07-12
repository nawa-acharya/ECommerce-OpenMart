'use strict';

// signup controller
app.controller('RegisterFormController', ['$scope', '$http', '$state', function($scope, $http, $state) {
    $scope.user = {};
    $scope.authError = null;
    $scope.register = function() {
      $scope.authError = null;
      // Try to create
        var data =  {
            user:{
                name: $scope.user.name,
                username: $scope.user.email,
                password: $scope.user.password
            }
        }

      $http.post('/register',data
      )
      .then(function(response) {
        if ( !response.data.user ) {
          $scope.authError = response;
        }else{

          $state.go('openmart.home');
        }
      }, function(x) {
        $scope.authError = 'Server Error';
      });
    };
  }])
 ;