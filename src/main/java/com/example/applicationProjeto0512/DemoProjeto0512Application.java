package com.example.applicationProjeto0512;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.example")
@EntityScan(basePackages = {"com.example.domains","com.example.domains.enums"})
@EnableJpaRepositories(basePackages = "com.example.repositories")
@SpringBootApplication
public class DemoProjeto0512Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjeto0512Application.class, args);
	}

}
