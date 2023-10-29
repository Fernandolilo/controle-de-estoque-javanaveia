package br.com.systempro.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ControlInStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlInStockApplication.class, args);	
		
	}

}
