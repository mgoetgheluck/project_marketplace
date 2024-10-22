package com.example.project_marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan("com.example.project_marketplace.repository")
@ComponentScan("com.example.project_marketplace.controllers")
@ComponentScan("com.example.project_marketplace.services")
@ComponentScan(basePackages = {"com.example.ProjectMarketplaceApplication"})
@EntityScan("com.example.project_marketplace.*")
public class ProjectMarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMarketplaceApplication.class, args);
	}

}
