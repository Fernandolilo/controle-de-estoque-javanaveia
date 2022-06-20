package br.com.javanaveia.client.domain.response.proxi;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.javanaveia.client.domain.response.Pedido;


@FeignClient(name = "produtos", url = "localhost:9000/sales-service/produtos/")
public interface PedidoProxi {

	@GetMapping(value = "/{id}")
	public Pedido getPedidoById(@PathVariable("id") Long id);

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Pedido> findByName(@RequestParam(name = "nome", required = true) String nome);
}
