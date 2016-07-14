/**
 * Created by Sandip on 7/13/16.
 */


function profileController($http,$rootScope,$scope){
     $scope.save = save;
     $scope.cancel = cancel;
     $scope.message =null

    function save(){
         console.log("Withinprofile save"+$rootScope.loggedUser)

        var url ='http://localhost:8090/openmart/api/user/profile/update/'+$rootScope.loggedUser.username

        $http.post(url,$rootScope.loggedUser.profile)
            .then(function(response) {
                if ( !response.data ) {
                    $scope.authError = 'Profile Couldnot be updated';
                }else{
                    console.log(angular.toJson(response.data))

                    $state.go('openmart.home.profile');
                    $scope.message="Profile has been successfully updated...."
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });

     }
    function cancel(){
        console.log($scope.profile)
        console.log($rootScope.loggedUser)
    }
}




function Profile(firstname,lastname,description,dateOfBirth,gender,image){
    this.firstname= firstname;
    this.lastname=lastname;
    this.dateOfBirth= dateOfBirth;
    this.gender= gender;
    this.image= image;
    this.description= description;
}