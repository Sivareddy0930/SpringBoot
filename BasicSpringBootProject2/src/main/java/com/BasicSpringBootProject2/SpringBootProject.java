package com.BasicSpringBootProject2;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//General Api Information using Annotations.
@OpenAPIDefinition(info = @Info(
		title = "Spring Boot Rest Api Documentation",
		description = "Spring Boot Rest Api Documentation",
		version = "v1.0",
		contact = @Contact(
				name = "siva",
				email = "siva@gmail.com",
				url = "https://www.javaReddy.com"

		),
		license = @License(
				name = "Apache 4.0",
				url = "https://www.javaReddy.com/licence"
		)
	),
		externalDocs= @ExternalDocumentation(
				description = "Spring Boot Rest Api Documentation",
				url = "https://www.javaReddy.com/Employee-managemnt.html"
		)


)
public class SpringBootProject {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject.class, args);
	}

}
