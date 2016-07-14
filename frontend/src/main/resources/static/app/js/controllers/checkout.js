/**
 * Created by Sandip on 7/12/16.
 */


function checkoutController($http, $scope, $rootScope, DataService,$state,AclService) {
    $scope.shipping = Shipping;
    $scope.payment = Payment;
    $scope.placeOrder = placeOrder
    $scope.cart = DataService.cart
    $scope.can = AclService.can;


        function placeOrder() {
        var orderLines = [];
        var payment = new Payment($scope.payment.cardNumber, $scope.payment.expiryMonth,
            $scope.payment.expiryYear, $scope.payment.cvvCode);
        var shipping =
            new Shipping($scope.shipping.firstName, $scope.shipping.lastName, $scope.shipping.address,
                $scope.shipping.city, $scope.shipping.phone, $scope.shipping.postCode, $scope.shipping.country);
        var counter = 0;
        for (var i = 0; i < $scope.cart.items.length; i++) {
            orderLines[counter] = new OrderLine($scope.cart.items[i].quantity, new Product($scope.cart.items[i].id))
            counter++;
        }
        var order = new Order(payment, shipping, orderLines);
        console.log(angular.toJson(order))
        var data =angular.toJson(order)
        console.log($rootScope.loggedUser.userId)
        $state.go('openmart.home.thankyou');
        //var url = 'http://localhost:8090/openmart/api/user/'+$rootScope.loggedUser.userId+'/order/create';
        //$http.post(url, data)
        //    .then(function(response) {
        //        if ( !response.data) {
        //            $scope.message = 'Order couldnot be placed';
        //            $scope.cart.clearItems();
        //            $state.go('openmart.home.checkout.thankyou');
        //
        //        }else{
        //            $scope.cart.clearItems();
        //            $state.go('openmart.home.checkout.thankyou');
        //        }
        //    }, function(x) {
        //        $scope.message = 'Server Error';
        //    });
    }
    function Shipping(firstName, lastName, address, city, phone, postCode, country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.address = address;
        this.postCode = postCode;
        this.country = country;
    }

    function OrderLine(quantity, product) {
        this.id = "";
        this.quantity = quantity;
        this.product = product;
    }

}

function Product(id) {
    this.id = id;
}
function Order(payment, shipping, orderLines) {
    this.id = "";
    this.payment = payment;
    this.shipping = shipping;
    this.orderLines = orderLines;
}

function Payment(cardNumber, expiryMonth, expiryYear, cvvCode) {
    this.cardNumber = cardNumber;
    this.expiryMonth = expiryMonth;
    this.expiryYear = expiryYear;
    this.cvvCode = cvvCode;
}




