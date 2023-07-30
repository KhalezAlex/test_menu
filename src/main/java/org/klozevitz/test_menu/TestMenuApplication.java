package org.klozevitz.test_menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TestMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMenuApplication.class, args);
	}

}
