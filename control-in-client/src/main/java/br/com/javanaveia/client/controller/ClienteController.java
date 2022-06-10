package br.com.javanaveia.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final ClienteService service;

	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByID(@PathVariable("id") Long id){
		Cliente client =  service.findById(id);
		return ResponseEntity.ok().body(client);
	}

}
