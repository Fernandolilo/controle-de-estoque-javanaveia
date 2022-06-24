package br.com.javanaveia.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.stereotype.Service;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.domain.Endereco;
import br.com.javanaveia.client.domain.DTO.ClientNewDTO;
import br.com.javanaveia.client.domain.DTO.ClienteDTO;
import br.com.javanaveia.client.domain.response.proxi.PedidoProxi;
import br.com.javanaveia.client.enums.Perfil;
import br.com.javanaveia.client.enums.TipoClient;
import br.com.javanaveia.client.repositories.ClienteRepository;
import br.com.javanaveia.client.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	private final ClienteRepository repository;
	private final PedidoProxi pedidoProxi;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public ClienteService(ClienteRepository repository, PedidoProxi pedidoProxi,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.repository = repository;
		this.pedidoProxi = pedidoProxi;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id);	
		return cliente.orElseThrow(
				() -> new ObjectNotFoundException("Identificador não encontrado" + "ID: "));
	}

	public List<ClienteDTO>  findByName(String nome) {
		List<ClienteDTO> cli = repository.findByNome(nome);
		 return cli;
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Cliente fromDto(ClientNewDTO obj) {
		Cliente cli = new Cliente(null, obj.getNome(), obj.getEmail(), bCryptPasswordEncoder.encode(obj.getPassword()), obj.getCpfOuCnpj(),
				TipoClient.toEnum(obj.getTipo()), Perfil.toEnum(obj.getPerfil()));
		Endereco end = new Endereco(null, obj.getLogradouro(), obj.getNumero(), obj.getComplemento(), obj.getCep(),
				obj.getCidade(), obj.getEstado(), cli);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(obj.getTelefone());
		if (obj.getTelefone1() != null) {
			cli.getTelefones().add(obj.getTelefone1());
		}
		if (obj.getTelefone2() != null) {
			cli.getTelefones().add(obj.getTelefone2());
		}
		return cli;
	}
}
