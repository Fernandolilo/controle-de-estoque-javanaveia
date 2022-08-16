package br.com.javanaveia.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.javanaveia.client.domain.Endereco;
import br.com.javanaveia.client.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	private final EnderecoService service;

	public EnderecoController(EnderecoService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> findByID(@PathVariable("id") Long id) {
		Endereco client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}


	
}
