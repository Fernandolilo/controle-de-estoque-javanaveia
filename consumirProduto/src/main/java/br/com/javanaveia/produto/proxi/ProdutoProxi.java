package br.com.javanaveia.produto.proxi;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.javanaveia.produto.responseClient.Produto;


@FeignClient(name = "produtos", url = "http://localhost:8000/produto-service/produtos")
public interface ProdutoProxi {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produto findById(@PathVariable Long id);
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Produto> findByName(@RequestParam(name = "nome", required = true) String nome);
		

}
