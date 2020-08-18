package com.org.user.registerSecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages={ "com.org"})
 
/*
 * @ComponentScan(basePackages = {"com.org"})
 * 
 * @EntityScan("com.org.user.model")
 */
@EnableJpaRepositories("com.org.user.repo")
@EntityScan(basePackages = "com.org.user.model")
public class SecureUserRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureUserRegisterApplication.class, args);
	}

}
