package br.com.javanaveia.client.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.domain.Endereco;
import br.com.javanaveia.client.repositories.EnderecoRepository;
import br.com.javanaveia.client.service.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	private final EnderecoRepository repository;

	@Autowired
	public EnderecoService(EnderecoRepository repository) {
		this.repository = repository;
	}
	
	public Endereco findById(Long id) {	
		Optional<Endereco> cliente = repository.findById(id);	
		return cliente.orElseThrow(
				() -> new ObjectNotFoundException("Identificador não encontrado" + "ID: "));
	}

	
	

}
