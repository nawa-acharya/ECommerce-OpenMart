/**
 * Created by Sandip on 7/13/16.
 */


function thankyouController($scope,$tate,DataService){
    DataService.cart.clearItems();



}

// add to footer
$("#menu-toggle").click(function(e){e.preventDefault();$("#wrapper").toggleClass("toggled");});

