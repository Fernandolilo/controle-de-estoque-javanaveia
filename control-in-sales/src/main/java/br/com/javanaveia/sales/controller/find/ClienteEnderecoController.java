package br.com.javanaveia.sales.controller.find;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javanaveia.sales.response.ClienteProxi;
import br.com.javanaveia.sales.response.EnderecoResponse;

@RestController
@RequestMapping(value = "/endereco")
public class ClienteEnderecoController {

	@Autowired
	private ClienteProxi response;

	@GetMapping(value = "/{id}")
	public EnderecoResponse getEndereco(@PathVariable("id") Long id) {
		return response.getByEnrederco(id);
	}

}
