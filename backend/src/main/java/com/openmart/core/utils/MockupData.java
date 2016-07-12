package com.openmart.core.utils;

import com.openmart.core.business.product.model.Product;
import com.openmart.core.business.product.model.ProductCatalogNew;
import com.openmart.core.business.product.service.ProductService;
import com.openmart.core.business.product.service.ProductServiceImp;
import com.openmart.core.business.user.model.Login;
import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Endalkachew on 12-Jul-16.
 */
@Component
public class MockUpData {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    public  void addSampleProducts(){
        Product product = new Product();
        product.setTitle("Test product 1");
        product.setPrice(100);
        product.setDescription("Description 1");
        product.setProductCatalog(new ProductCatalogNew(10, true));

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Test product 2");
        product.setPrice(50);
        product.setDescription("Description 2");
        product.setProductCatalog(new ProductCatalogNew(20, true));

        productService.addProduct(product);
    }

    public void addSampleUser(){
        Login x = new Login("x", "x");
        User user = new User("x", "x", "x");

        userService.addUser(user);
    }
}
