package com.openmart;


import com.openmart.core.utils.MockupData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BackendApplication.class, args);

		MockupData mockupData = (MockupData)context.getBean(MockupData.class);
		mockupData.addSampleProducts();
		mockupData.addSampleUser();
	}
}
