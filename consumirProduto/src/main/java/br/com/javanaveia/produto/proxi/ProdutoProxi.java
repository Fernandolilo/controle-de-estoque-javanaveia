package br.com.javanaveia.produto.proxi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.javanaveia.produto.Produto;


@FeignClient(name = "produtos", url = "http://localhost:8000/produto-service/produtos")
public interface ProdutoProxi {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produto findById(@PathVariable Long id);

}
