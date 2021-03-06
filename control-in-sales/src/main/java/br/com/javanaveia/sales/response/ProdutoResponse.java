package br.com.javanaveia.sales.response;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.javanaveia.sales.domain.Produto;

/*
 * @FeignClient(name = "produtos", url =
 * "http://localhost:8081/produto-service/produtos/1") public interface
 * ProdutoRespponse {
 * 
 * @RequestMapping(method = RequestMethod.GET, value = "") Produto getProduto();
 * }
 */

@FeignClient(name = "produtos", url = "localhost:8000/produto-service/produtos/")
public interface ProdutoResponse {

	@GetMapping(value = "/{id}")
	public Produto getProduto(@PathVariable("id") Long id);

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Produto> findByName(@RequestParam(name = "nome", required = true) String nome);
}
