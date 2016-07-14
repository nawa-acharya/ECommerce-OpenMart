package com.openmart;


import com.openmart.core.utils.MockUpData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BackendApplication.class, args);

		MockUpData mockUpData = (MockUpData)context.getBean(MockUpData.class);
		//mockUpData.addSampleProducts();
		//mockUpData.addSampleUser();
	}
}
