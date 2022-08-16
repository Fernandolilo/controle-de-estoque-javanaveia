package br.com.javanaveia.sales.response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.javanaveia.sales.domain.Client;

@FeignClient(name = "client-service"/* , url = "http://localhost:7000/client-service/clientes/" */)
public interface ClienteProxi {
	
	
	@GetMapping(value = "client-service/clientes/{id}")
	public Client getClienteById(@PathVariable("id") Long id);
	
	@GetMapping(value = "client-service/endereco/{id}")
	public EnderecoResponse getByEnrederco(@PathVariable("id") Long id);
}
