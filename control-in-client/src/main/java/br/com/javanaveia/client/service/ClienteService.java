package br.com.javanaveia.client.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.repositories.ClienteRepository;
import br.com.javanaveia.client.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	private final ClienteRepository repository;

	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	
	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Identificador não encontrado" + "ID: " ));
	}
	

}
