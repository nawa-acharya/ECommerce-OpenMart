package com.openmart.core.utils;

import com.openmart.core.business.product.model.Product;
import com.openmart.core.business.product.model.ProductCatalog;
import com.openmart.core.business.product.service.ProductService;
import com.openmart.core.business.user.model.Login;
import com.openmart.core.business.user.model.Role;
import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Endalkachew on 12-Jul-16.
 */
//mokeup data for user and product
@Component
public class MockUpData {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    public  void addSampleProducts(){
        Product product = new Product();
        product.setTitle("Doughnuts");
        product.setPrice(1.99);
        product.setDescription("Tasty small sized doughnuts");
        product.setProductCatalog(new ProductCatalog(10, true));

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Bakery");
        product.setPrice(50);
        product.setDescription("Fresh bakery items");
        product.setProductCatalog(new ProductCatalog(20, true));

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Diet Coke");
        product.setPrice(2);
        product.setDescription("Diet Coke contains no added sugar, 0% carbondioxide");
        product.setProductCatalog(new ProductCatalog(25, true));

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Pure Sugar");
        product.setPrice(2.99);
        product.setDescription("15 calories per serving");
        product.setProductCatalog(new ProductCatalog(20, true));

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Head and Shoulders");
        product.setPrice(2.99);
        product.setDescription("anti dandruff shampoo");
        product.setProductCatalog(new ProductCatalog(30, true));

        productService.addProduct(product);
    }

    public void addSampleUser(){
        Role role = new Role();
        Login x = new Login("admin", "admin");
        User user = new User("Team_Water", "admin", "admin");
        Set<Role> setAdminRole = new HashSet<Role>();

        role.setRole("ROLE_ADMIN");
        setAdminRole.add(role);
        user.setRoles(setAdminRole);

        userService.addUser(user);

        role = new Role();
        user = new User("Lionel Messi", "user1", "pass1");

        role.setRole("ROLE_USER");
        setAdminRole.add(role);
        user.setRoles(setAdminRole);

        userService.addUser(user);

        role = new Role();
        user = new User("Ronaldinho", "user2", "pass2");

        role.setRole("ROLE_USER");
        setAdminRole.add(role);
        user.setRoles(setAdminRole);

        userService.addUser(user);
    }
}
