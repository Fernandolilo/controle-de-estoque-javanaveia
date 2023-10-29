package br.com.systempro.stock.contiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title = "Control-in-stock",
      version = "V1",
      description = "Documentation of Control-in-stock Service API",
      contact = @Contact(
    		  url = "https://www.youtube.com/watch?v=muFjGbMAmng&list=PLCz6hOJfH9nvB12thX96pyxauTm-ATltP", 
      name = "Fernando Silva", email = "nando.systempro@hotmail.com")
))

@Configuration  
public class OpenConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {		
		return new OpenAPI()				
				.components(new Components())
				.info(
					new io.swagger.v3.oas.models.info.Info()
					.title("Control in stock API")
					.version("v1")				
					.license(new License()
							.name("Apache  2.0")
							.url("http://springdoc.org")
					)
			);
		
	}
}