/**
 * Created by Sandip on 7/14/16.
 */

function logoutController($state,$rootScope,DataService,AclService){

    DataService.cart.clearItems();
    AclService.flushRoles();
    AclService.attachRole('ROLE_GUEST');
    $rootScope.loggedUser={};
     $state.go('openmart.home.store')


}
