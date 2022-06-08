package br.com.javanaveia.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.repositories.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository repository;

	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	

}
