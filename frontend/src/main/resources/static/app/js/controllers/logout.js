/**
 * Created by Sandip on 7/14/16.
 */

function logoutController($state,$scope,$rootScope,DataService,AclService){
    $scope.can = AclService.can;
    DataService.cart.clearItems();
    AclService.flushRoles();
    AclService.attachRole('ROLE_GUEST');
    $rootScope.loggedUser={};
     $state.go('openmart.home.store')
     $scope.logout = null;


}
