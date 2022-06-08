package br.com.javanaveia.client.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.javanaveia.client.service.InitializerDataBase;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Autowired
	private InitializerDataBase dbIni;
	
	@Bean
	public boolean initializerBD() {
		dbIni.initialaizerDataBaseTest();
		return true;
	}

}
