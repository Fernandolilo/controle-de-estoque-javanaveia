package br.com.javanaveia.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Produto> findByName(@RequestParam(name = "nome", required = true) String nome){
		List<Produto> list = response.findByName(nome);	
		return list;
	}

}
