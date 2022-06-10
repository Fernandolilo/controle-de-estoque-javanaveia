package br.com.javanaveia.sales.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.javanaveia.sales.domain.Pedido;
import br.com.javanaveia.sales.domain.dto.PedidoDTO;
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
	
	@RequestMapping(value = "/page",produces = { "application/json", "application/xml", "application/yaml" }, method = RequestMethod.GET)
	public ResponseEntity<Page<PedidoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "instante") String nome) {

		Page<Pedido> list = service.findPage(page, linesPerPage, nome, direction);
		Page<PedidoDTO> listDTO = list.map(obj -> new PedidoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
