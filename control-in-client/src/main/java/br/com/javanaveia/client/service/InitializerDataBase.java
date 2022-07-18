package br.com.javanaveia.client.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.domain.Endereco;
import br.com.javanaveia.client.enums.Perfil;
import br.com.javanaveia.client.enums.TipoClient;
import br.com.javanaveia.client.repositories.ClienteRepository;
import br.com.javanaveia.client.repositories.EnderecoRepository;

@Service
public class InitializerDataBase {

	private final ClienteRepository clienteRepository;
	private final EnderecoRepository enderecoRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Autowired
	public InitializerDataBase(ClienteRepository clienteRepository, 
			EnderecoRepository enderecoRepository) {
		this.clienteRepository = clienteRepository;
		this.enderecoRepository = enderecoRepository;
	}

	public void initialaizerDataBaseTest() {

		Cliente cli1 = new Cliente(null, "Fernando", "fernando@gmail",bCryptPasswordEncoder.encode("1234"), "1234", TipoClient.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("11 1234-1234", "11 9 7894-7894"));
		//cli1.addPerfil(Perfil.ADMINISTRADOR);
		
		Endereco end1 = new Endereco(null, "Rua xpto", 56, "", "121345-000", "São Paulo", "SP", cli1);
		
		cli1.getEnderecos().add(end1);

		clienteRepository.save(cli1);
		enderecoRepository.save(end1);

	}
}
