package com.produtos.apirest.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	//
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))//pacote onde estão todas as classes JAVA
                .paths(regex("/api.*")) //Mostra o caminho para poder acessar, que foi definido no Resourt em @RequestMapping
                .build()		
                .apiInfo(metaInfo()); // Chama o método metaInfo, criado abaixo
    }

	
	
	//Serve para mostar as informações que deseja, exemplo: dados da pessoa que fez a API
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST",
                "API REST de cadastro de produtos. "
                + " Created by Paulo Morais",
                "1.0",
                "Terms of Service",
                new Contact("Paulo Morais", "https://github.com/paulomorais97",
                        "paulo-2109@hotmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}