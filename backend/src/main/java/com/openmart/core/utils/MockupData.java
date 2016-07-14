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
        product.setTitle("Guitar");
        product.setPrice(25);
        product.setDescription("Acoustic, , 6 string, a Yamaha product" );
        product.setProductCatalog(new ProductCatalog(10, true));
        product.setImage(1);

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Diet Coke");
        product.setPrice(2);
        product.setDescription("Contains no added sugar, 0% carbondioxide, Sugar Free Drink, A coca cola product");
        product.setProductCatalog(new ProductCatalog(25, true));
        product.setImage(2);

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Nescafe Clasico");
        product.setPrice(6.65);
        product.setDescription("Good food, Good life, Nestle, Rich, bld flavor in every cup.");
        product.setProductCatalog(new ProductCatalog(20, true));
        product.setImage(3);

        productService.addProduct(product);


        product = new Product();

        product.setTitle("Axe- Daily Fragrance");
        product.setPrice(2.99);
        product.setDescription("Unique premium daily fragrance to keep you smelling great all day or all night");
        product.setProductCatalog(new ProductCatalog(20, true));
        product.setImage(4);

        productService.addProduct(product);

        product = new Product();

        product.setTitle("Head and Shoulders");
        product.setPrice(2.99);
        product.setDescription("anti dandruff shampoo + conditioner, formerly 'hair endurance', cleans to restore fullness to thinning hair");
        product.setProductCatalog(new ProductCatalog(30, true));
        product.setImage(5);

        productService.addProduct(product);
    }

    public void addSampleUser(){
        Role role = new Role();
        User admin = new User("Team_Water", "mytrial4@gmail.com", "admin");
        Set<Role> setAdminRole = new HashSet<Role>();

        setAdminRole.add(new Role("ROLE_ADMIN"));
        admin.setRoles(setAdminRole);

        userService.addUser(admin);


        User user1 = new User("Nawa Raj", "user1@gmail.com", "pass1");

        Set<Role> user1Roles = new HashSet<Role>();
        user1Roles.add(new Role("ROLE_USER"));
        user1.setRoles(user1Roles);
       // user1.getProfile().setImage("user1");

        userService.addUser(user1);


        User user2 = new User("Sandip", "user2@gmail.com", "pass2");

        Set<Role> user2Roles = new HashSet<Role>();
        user2Roles.add(new Role("ROLE_USER"));
        user2.setRoles(user2Roles);
       //user2.getProfile().setImage("user2");

        User user3 = new User("Nischal", "user3@gmail.com", "pass3");
        Set<Role> user3Roles = new HashSet<Role>();
        user3Roles.add(new Role("ROLE_USER"));
        user3.setRoles(user3Roles);
        userService.addUser(user3);
    }
}
