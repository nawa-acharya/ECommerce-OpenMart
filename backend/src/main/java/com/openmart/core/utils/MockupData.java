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
public class MockupData {

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
        User admin = new User("Team_Water", "mytrial4@gmail.com", "admin");
        Set<Role> setAdminRole = new HashSet<Role>();

        setAdminRole.add(new Role("ROLE_ADMIN"));
        admin.setRoles(setAdminRole);

        userService.addUser(admin);


        User user1 = new User("Lionel Messi", "user1@gmail.com", "pass1");

        Set<Role> user1Roles = new HashSet<Role>();
        user1Roles.add(new Role("ROLE_USER"));
        user1.setRoles(user1Roles);

        userService.addUser(user1);


        User user2 = new User("Lionel Messi", "user1@gmail.com", "pass1");

        Set<Role> user2Roles = new HashSet<Role>();
        user2Roles.add(new Role("ROLE_USER"));
        user2.setRoles(user2Roles);


        User user3 = new User("Ronaldinho", "user2@gmail.com", "pass2");
        Set<Role> user3Roles = new HashSet<Role>();
        user3Roles.add(new Role("ROLE_USER"));
        user3.setRoles(user3Roles);
        userService.addUser(user3);
    }
}
