
function store() {
this.products = null;
store.prototype.getProduct = function (id) {
    console.log(this.products)
    for (var i = 0; i < this.products.length; i++) {
        if (this.products[i].id == id)
            return this.products[i];
    }

}
}
