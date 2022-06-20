package br.com.javanaveia.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.javanaveia.produto.Produto;
import br.com.javanaveia.produto.proxi.ProdutoProxi;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoProxi proxi;

	@Autowired
	public ProdutoController(ProdutoProxi proxi) {
		this.proxi = proxi;
	}

	@GetMapping
	public Produto getProduto() {
		Produto p = new Produto(1L, "Furadeira", "Bosh", "furadeira 127V de impacto", 250.99, 10);
		return p;
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public Produto getProdutosById(@PathVariable("id") Long id) {
		return proxi.findById(id);
	}
}
