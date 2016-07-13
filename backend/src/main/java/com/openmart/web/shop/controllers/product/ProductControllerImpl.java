package com.openmart.web.shop.controllers.product;

import com.openmart.core.business.product.model.Product;
import com.openmart.core.business.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 12-Jul-16.
 */
@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "openmart/api/product")
public class ProductControllerImpl {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts() {
        return productService.listProduct();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addProduct(@RequestBody Product product) {
         productService.addProduct(product);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
}