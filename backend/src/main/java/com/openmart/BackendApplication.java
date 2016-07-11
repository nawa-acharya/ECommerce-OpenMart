package com.openmart;

import com.openmart.core.business.user.controller.UserController;
import com.openmart.core.business.user.model.Login;
import com.openmart.core.business.user.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BackendApplication.class, args);
        ApplicationContext context = SpringApplication.run(BackendApplication.class, args);
        UserController userController = context.getBean("userController", UserController.class);
        userController.test();
        userController.addUserService(new User("Nawa Raj Acharya", new Login("username", "password")));
	}
}
