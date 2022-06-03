package br.com.javanaveia.sales.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.javanaveia.sales.domain.Pedido;
import br.com.javanaveia.sales.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService service;

	@Autowired
	public PedidoController(PedidoService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Void> insert (@Valid @RequestBody Pedido obj){
		Pedido ped = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ped.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Pedido>> findById(@PathVariable Long id) {
		Optional<Pedido> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
