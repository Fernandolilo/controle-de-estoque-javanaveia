package br.com.javanaveia.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfiguration {
	
	@Bean
	public boolean initializerBD() {
		return true;
	}

}
