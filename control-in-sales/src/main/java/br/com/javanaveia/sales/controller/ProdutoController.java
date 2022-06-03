package br.com.javanaveia.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javanaveia.sales.domain.Produto;
import br.com.javanaveia.sales.response.ProdutoResponse;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoResponse response;
	
	@GetMapping(value= "/{id}")
	public Produto getProdutos(@PathVariable("id") Long id) {
		return response.getProduto(id);
		 
	}

}
