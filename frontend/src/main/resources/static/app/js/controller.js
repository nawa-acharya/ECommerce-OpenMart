'use strict';

// the storeController contains two objects:
// - store: contains the product list
// - cart: the shopping cart object
function storeController($scope, $stateParams, DataService, $http,$state,$rootScope,AclService) {
    $scope.can = AclService.can;
    $rootScope.can = AclService.can;

    // get store and cart from service
    //$http.get('data/products.json').success(function(data){
    //    $rootScope.store.products = data;
    //})
    $http.get('http://localhost:8090/openmart/api/product/list').success(function(data){
        $rootScope.store.products = data;
    });
    //$scope.cart = DataService.cart;
    //$scope.store=DataService.store;
    $rootScope.cart = DataService.cart;
    $rootScope.store=DataService.store;
    // use routing to pick the selected product
    if ($stateParams.productSku != null) {
       // $scope.product = $scope.store.getProduct($stateParams.productSku);
       // $scope.product = $scope.store.getProduct($stateParams.productSku);
        for (var i = 0; i < $rootScope.store.products.length; i++) {
            if ( $rootScope.store.products[i].id ==$stateParams.productSku)
                $rootScope.product=   $rootScope.store.products[i];
                console.log( $rootScope.product)
        }
    }
}
