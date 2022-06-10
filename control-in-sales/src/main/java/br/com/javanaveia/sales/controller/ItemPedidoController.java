package br.com.javanaveia.sales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.domain.dto.ItemPedidoDTO;
import br.com.javanaveia.sales.service.ItemPedidoService;

@RestController
@RequestMapping("/itensvendidos")
public class ItemPedidoController {

	private final ItemPedidoService service;

	@Autowired
	public ItemPedidoController(ItemPedidoService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<ItemPedido>> findById(@PathVariable Long id) {
		Optional<ItemPedido> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<ItemPedidoDTO> findByName(@RequestParam(name = "nome", required = true) String nome){
		List<ItemPedidoDTO> list = service.findByName(nome);
		return list;
	}
}
