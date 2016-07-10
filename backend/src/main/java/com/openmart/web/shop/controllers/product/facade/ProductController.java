package com.openmart.web.shop.controllers.product.facade;

import com.openmart.core.business.product.model.Product;
import com.openmart.core.business.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Oops on 7/11/2016.
 */
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(value = "/listproduct",method = RequestMethod.GET,headers = "Accept=Application/json")
    public List<Product> getListProduct(){
        List<Product> productList=productService.listProduct();
        return  productList;
    }
    @RequestMapping(value = "/product/{id}",method = RequestMethod.GET,headers = "Accept=Application/json")
    public Product getProduct(@PathVariable int id){
        Product product=productService.getById(id);
        return  product;

    }
}
