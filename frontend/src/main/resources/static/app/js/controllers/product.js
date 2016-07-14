/**
 * Created by Sandip on 7/13/16.
 */


function productController($http,$scope,$rootScope,DataService,$state,AclService){
    $scope.product=Product;
    $scope.save = save;
    $scope.cancel=cancel;
    $scope.can = AclService.can;
    function save(){
        console.log($scope.product)
        var prod = new Product(1,
            $scope.product.title,
            $scope.product.description, $scope.product.price,  $scope.product.category);
        var data =angular.toJson(prod);
        $http.post('http://localhost:8090/openmart/api/product/add',data)
            .then(function(response) {
                if ( !response.data ) {
                    console.log("prduct added")
                    updateStore();
                    $scope.message = "Product added ";
                }else{
                    console.log("prduct added")
                    updateStore();
                }
            }, function(x) {
                $scope.authError = 'Server Error';
            });
    }
    function cancel(){
        console.log($scope.product)
    }

    function updateStore(){
        console.log("updateStore")
        $http.get('http://localhost:8090/openmart/api/product/list').success(function(data){
            $rootScope.store =DataService.store
            $rootScope.store.products = data;
            $state.go('openmart.home.store');

        });
    }
}
function Product( id,title, description, price, category, image,isAvailable) {
    this.id =id;
    this.title =title;
    this.description =description;
    this.price =price;
    this.category =category;
    this.image=image;
    this.isAvailable=isAvailable;
}