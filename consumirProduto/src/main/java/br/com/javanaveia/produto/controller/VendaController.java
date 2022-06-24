package br.com.javanaveia.produto.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.javanaveia.produto.domain.Venda;
import br.com.javanaveia.produto.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

	private final VendaService service;

	@Autowired
	public VendaController(VendaService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Venda>> findById(@PathVariable Long id) {
		Optional<Venda> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	//@PostMapping
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Venda> create(@Valid @RequestBody Venda obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
