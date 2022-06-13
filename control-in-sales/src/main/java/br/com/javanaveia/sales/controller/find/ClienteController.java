package br.com.javanaveia.sales.controller.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javanaveia.sales.domain.Client;
import br.com.javanaveia.sales.response.ClienteProxi;

@RestController
@RequestMapping(value = "clientes")
public class ClienteController {

	@Autowired
	private ClienteProxi response;

	@GetMapping(value = "/{id}")
	public Client getClientes(@PathVariable("id") Long id) {
		return response.getClienteById(id);
	}

}
