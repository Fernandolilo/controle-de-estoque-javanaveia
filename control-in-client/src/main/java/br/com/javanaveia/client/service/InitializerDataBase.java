package br.com.javanaveia.client.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.domain.Endereco;
import br.com.javanaveia.client.repositories.ClienteRepository;
import br.com.javanaveia.client.repositories.EnderecoRepository;

@Service
public class InitializerDataBase {

	private final ClienteRepository clienteRepository;
	private final EnderecoRepository enderecoRepository;
	
	@Autowired
	public InitializerDataBase(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
		this.clienteRepository = clienteRepository;
		this.enderecoRepository = enderecoRepository;
	}


	public void initialaizerDataBaseTest() {
		
		Cliente cli1 = new Cliente(null,"Fernando", "fernando@gmail", "1234", "1234");
		cli1.getTelefones().addAll(Arrays.asList("11 1234-1234", "11 9 7894-7894"));
		
		Endereco end1 = new Endereco(null, "Rua xpto", 56, "", "121345-000", "São Paulo", "SP", cli1);
		
		cli1.getEnderecos().add(end1);
		
		clienteRepository.save(cli1);
		enderecoRepository.save(end1);
	}
}
