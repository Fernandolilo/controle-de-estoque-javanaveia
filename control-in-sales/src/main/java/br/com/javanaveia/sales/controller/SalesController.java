package br.com.javanaveia.sales.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.javanaveia.sales.domain.Sales;
import br.com.javanaveia.sales.repositoryes.SalesRepository;
import br.com.javanaveia.sales.response.ProdutoResponse;
import br.com.javanaveia.sales.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {

	private final ProdutoResponse response;
	private final SalesRepository repository;
	private final SalesService service;

	@Autowired
	public SalesController(ProdutoResponse response, SalesRepository repository, SalesService service) {
		this.response = response;
		this.repository = repository;
		this.service = service;
	}

	// passando parametros direto para a class e sem recuperar nada do
	// produtoResponse ou proxi

	/*@GetMapping
	public ResponseEntity<Sales> get() {
		Sales sa = new Sales(null, new Date(), 1L);
		return ResponseEntity.ok().body(sa);
	}*/

	// recuperando valor do produto
	/*
	 * @GetMapping(value = "/{id}") public ResponseEntity<Sales>
	 * get(@PathVariable("id") Long id) { Long idd = 1L; Produto p =
	 * response.getProduto(idd); p.getMarca(); p.getNome(); Sales sa = new Sales(1L,
	 * new Date(), p.getId(), p.getNome(), p.getMarca(), p.getPreco(), 10); return
	 * ResponseEntity.ok().body(sa); }
	 */

	// recuperando valor do produto

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Sales>> get(@PathVariable("id") Long id) {
		Optional<Sales> obj = repository.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Sales obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
}
