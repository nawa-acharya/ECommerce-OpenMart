/**
 * Created by Sandip on 7/9/16.
 */
var app = angular.module('openmart', ["ui.router"])
app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/openmart/home")

    $stateProvider
        .state('openmart', {
            abstract: true,
            url: "/openmart",
            templateUrl: "partials/app.html"
        })
        .state('openmart.home', {
            url: "/home",
            templateUrl: "partials/app-dashboard.html"
        })
        .state('openmart.home.store', {
            url: "/store",
            templateUrl: "partials/store.html",
            controller: storeController
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
            templateUrl: "partials/product-add.html"
        }).state('access', {
        abstract:true,
        url: "/access",
         template: '<div ui-view class=""></div>'
    }).state('access.login', {
        url: "/openmart/login",
        templateUrl: "partials/login.html"
    }) .state('access.register', {
            url: "/openmart/register",
            templateUrl: "partials/register.html"
        }).state('openmart.home.checkout', {
        url: "/openmart/checkout",
        templateUrl: "partials/checkout.html",
        controller: checkoutController
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

