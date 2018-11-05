package com.iconic.keygenerator.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.iconic.keygenerator.repository"})
@EntityScan(basePackages = {"com.iconic.keygenerator.models"})
@ComponentScan("com.iconic")
public class IconicClientkeyGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IconicClientkeyGeneratorApplication.class, args);
	}
}
