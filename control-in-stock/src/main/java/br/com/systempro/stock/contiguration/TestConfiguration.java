package br.com.systempro.stock.contiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.systempro.stock.service.DBService;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() {
		dbService.instantiateDatabase();
		return true;
	}

}
