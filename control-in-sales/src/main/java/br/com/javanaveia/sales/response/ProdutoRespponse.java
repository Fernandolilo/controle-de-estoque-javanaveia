package br.com.javanaveia.sales.response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.javanaveia.sales.domain.Produto;

/*
 * @FeignClient(name = "produtos", url =
 * "http://localhost:8081/produto-service/produtos/1") public interface
 * ProdutoRespponse {
 * 
 * @RequestMapping(method = RequestMethod.GET, value = "") Produto getProduto();
 * }
 */


@FeignClient(name = "produtos", url = "localhost:8081/produto-service/produtos/")
public interface ProdutoRespponse {

	@GetMapping(value = "/{id}")
	public Produto getProduto(@PathVariable("id") Long id);
}
