package com.example.ec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.any;
//import springfox.documentation.builders.PathSelectors;
//import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Main Class for the Spring Boot Application
 *
 * Created by Osvaldo Martini
 */
@SpringBootApplication
@EnableSwagger2
public class ExplorecaliApplication {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                //.apis(RequestHandlerSelectors.basePackage("com.example.ec")).paths(PathSelectors.regex("/.*")).build()
				.apis(RequestHandlerSelectors.basePackage("com.example.ec")).paths(any()).build()
				.forCodeGeneration(true)
                .apiInfo(new ApiInfo("Explore Template API's", "API's for Template", "2.0", null,
						new Contact("Osvaldo Martini", "http://localhost:9090", "maos@corner.ch"),
						null, null, new ArrayList()));
    }

	public static void main(String[] args) {
		SpringApplication.run(ExplorecaliApplication.class, args);
	}

}
