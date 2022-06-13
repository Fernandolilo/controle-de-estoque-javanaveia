package br.com.javanaveia.client.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.domain.DTO.ClientNewDTO;
import br.com.javanaveia.client.domain.DTO.ClienteDTO;
import br.com.javanaveia.client.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService service;

	public ClienteController(ClienteService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByID(@PathVariable("id") Long id) {
		Cliente client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<ClienteDTO> findByName(@RequestParam(name = "nome") String nome) {
		List<ClienteDTO> cliente = service.findByName(nome);
		return cliente;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> insert(@Valid @RequestBody ClientNewDTO obj) {
		Cliente newObj = service.fromDto(obj);
		newObj = service.insert(newObj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
