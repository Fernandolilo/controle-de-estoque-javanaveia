package br.com.javanaveia.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ControlInSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlInSalesApplication.class, args);
	}

}
