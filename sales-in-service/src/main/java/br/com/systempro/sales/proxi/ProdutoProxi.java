package br.com.systempro.sales.proxi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.systempro.sales.response.Produto;

@FeignClient(name = "produto-service")
public interface ProdutoProxi {	

	/*
	 * desta forma ele ja sabe; buscar os dados de forma dinamica, sabendo abistrair
	 * tudo que for necessarios dentro da aplicação, não havendo a necessidade do RestTemplate
	 */
	@GetMapping(value ="produto-service/{id}")
	public Produto getProduto(
			@PathVariable Long id);
}
