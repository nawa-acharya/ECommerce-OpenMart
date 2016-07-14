/**
 * Created by Sandip on 7/9/16.
 */
var app = angular.module('openmart', ["ui.router",'mm.acl'])
app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/openmart/home")

    $stateProvider
        .state('openmart', {
            abstract: true,
            url: "/openmart",
            templateUrl: "partials/app.html",
        })
        .state('openmart.home', {
            url: "/home",
            templateUrl: "partials/app-dashboard.html",
        })
        .state('openmart.home.store', {
            url: "/store",
            templateUrl: "partials/store.html",
            controller: storeController,
        }).state('openmart.home.cart', {
        url: "/cart",
        templateUrl: "partials/cart.html",
        controller: storeController
    }).state('openmart.home.product-view', {
        url: "/product-view/:productSku",
        templateUrl: "partials/product-view.html",
        controller: storeController

    }).state('openmart.home.product-edit', {
            url: "/product-edit",
            templateUrl: "partials/product-edit.html"

        })
        .state('openmart.home.product-add', {
            url: "/product-add",
            templateUrl: "partials/product-add.html",
            controller:productController,
            resolve : {
                'acl' : ['$q', 'AclService', function($q, AclService){
                    if(AclService.can('manage_product')){
                        // Has proper permissions
                        return true;
                    } else {
                        // Does not have permission
                        return $q.reject('Unauthorized');
                    }
                }]
            }
        }).state('access', {
        abstract:true,
        url: "/access",
         template: '<div ui-view class=""></div>'
    })  .state('openmart.home.profile', {
            url: "/profile",
            templateUrl: "partials/profile.html",
            controller:profileController,
            resolve : {
                'acl' : ['$q', 'AclService', function($q, AclService){
                    if(AclService.can('manage_profile')){
                        // Has proper permissions
                        return true;
                    } else {
                        // Does not have permission
                        return $q.reject('Unauthorized');
                    }
                }]
            }
        })
        .state('access.login', {
        url: "/openmart/login",
        templateUrl: "partials/login.html",
            resolve : {
                'acl' : ['$q', 'AclService', function($q, AclService){
                    if(AclService.can('login')){
                        // Has proper permissions
                        return true;
                    } else {
                        // Does not have permission
                        return $q.reject('Unauthorized');
                    }
                }]
            }
    }) .state('access.register', {
            url: "/openmart/register",
            templateUrl: "partials/register.html"
        }).state('openmart.home.checkout', {
        url: "/openmart/checkout",
        templateUrl: "partials/checkout.html",
        controller: checkoutController,
        resolve : {
            'acl' : ['$q', 'AclService', function($q, AclService){
                if(AclService.can('checkout')){
                    // Has proper permissions
                    return true;
                } else {
                    // Does not have permission
                    return $q.reject('Unauthorized');
                }
            }]
        }
    }).state('openmart.home.checkout.thankyou', {
        url: "/thankyou",
        templateUrl: "partials/thankyou.html",
        controller: thankyouController,
        resolve : {
            'acl' : ['$q', 'AclService', function($q, AclService){
                if(AclService.canAny('checkout')){
                    // Has proper permissions
                    return true;
                } else {
                    // Does not have permission
                    return $q.reject('Unauthorized');
                }
            }]
        }
    }).state('access.logout', {
        url: "/logout",
        controller: logoutController,
        resolve : {
            'acl' : ['$q', 'AclService', function($q, AclService){
                if(AclService.can('checkout')){
                    // Has proper permissions
                    return true;
                } else {
                    // Does not have permission
                    return $q.reject('Unauthorized');
                }
            }]
        }
    })
});
// create a data service that provides a store and a shopping cart that
// will be shared by all views (instead of creating fresh ones for each view).
app.factory("DataService", function ($http) {

   var myStore = new store($http);
    // create shopping cart
    var myCart = new shoppingCart("OpenMartStore");

    // return data object with store and cart
    return {
        store: myStore,
        cart: myCart
    };
});

app.run(['AclService', function (AclService) {

    // Set the ACL data. Normally, you'd fetch this from an API or something.
    // The data should have the roles as the property names,
    // with arrays listing their permissions as their value.
    var aclData = {
        ROLE_ADMIN: ['logout','manage_profile','manage_product','checkout'],
        ROLE_USER: ['checkout','manage_profile'],
        ROLE_GUEST: ['login']
    }
    console.log(aclData);
    AclService.setAbilities(aclData);
    // Attach the member role to the current user
   AclService.attachRole('ROLE_GUEST');
}]);
app.run(['$rootScope', '$location', function ($rootScope, $location) {
    // If the route change failed due to our "Unauthorized" error, redirect them
    $rootScope.$on('$routeChangeError', function(current, previous, rejection){
        if(rejection === 'Unauthorized'){
            $location.path('/login');
        }
    })
}]);



