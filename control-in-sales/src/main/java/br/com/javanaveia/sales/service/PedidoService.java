package br.com.javanaveia.sales.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.javanaveia.sales.domain.Client;
import br.com.javanaveia.sales.domain.Cliente;
import br.com.javanaveia.sales.domain.Endereco;
import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.domain.Pedido;
import br.com.javanaveia.sales.domain.Produto;
import br.com.javanaveia.sales.domain.enums.StatusPedido;
import br.com.javanaveia.sales.repositoryes.EnderecoRepository;
import br.com.javanaveia.sales.repositoryes.ItemPedidoRepository;
import br.com.javanaveia.sales.repositoryes.PedidoClienteRepository;
import br.com.javanaveia.sales.repositoryes.PedidoRepository;
import br.com.javanaveia.sales.response.ClienteProxi;
import br.com.javanaveia.sales.response.EnderecoResponse;
import br.com.javanaveia.sales.response.ProdutoResponse;

@Service
public class PedidoService {

	private final ItemPedidoRepository itemPedidoRepository;
	private final PedidoRepository pedidoRepository;
	private final ProdutoResponse response;
	private final ClienteProxi clienteProxi;
	private final PedidoClienteRepository pedidoClienteRepository;
	private final EnderecoRepository enderecoRepository;

	@Autowired
	public PedidoService(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository,
			ProdutoResponse response, ClienteProxi clienteProxi, PedidoClienteRepository pedidoClienteRepository,
			EnderecoRepository enderecoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
		this.pedidoRepository = pedidoRepository;
		this.response = response;
		this.clienteProxi = clienteProxi;
		this.pedidoClienteRepository = pedidoClienteRepository;
		this.enderecoRepository = enderecoRepository;

	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(LocalDateTime.now());
		obj.setStatus(StatusPedido.valueOf(obj.getStatus().toString()));
		obj.setIdProduto(obj.getIdProduto());
		obj.setIdCliente(obj.getIdCliente());
		// obj.setIdEndereco(obj.getIdEndereco());
		Client cli = clienteProxi.getClienteById(obj.getIdCliente());
		Produto prod = response.getProduto(obj.getIdProduto());

		// Optional<Endereco> emp =
		// enderecoRepository.findById(obj.getEndereco().getId());
		obj = pedidoRepository.save(obj);
		for (ItemPedido ip : obj.getItens()) {
			if (ip.getId() == null) {
				ip.setIdProduto(prod.getId());
				ip.setMarca(prod.getMarca());
				ip.setNome(prod.getMarca());
				ip.setDescricao(prod.getDescricao());
				ip.setPreco(prod.getPrecoVenda());
				ip.setQuantidade(ip.getQuantidade());
				ip.setPedido(obj);
			}

		}

		Cliente cp = new Cliente(null, obj.getIdCliente(), cli.getNome(), cli.getEmail(), cli.getCpfOuCnpj(), obj);
		EnderecoResponse er = clienteProxi.getByEnrederco(obj.getIdEndereco());

		Endereco e = new Endereco(null, er.getLogradouro(), er.getNumero(), er.getComplemento(), er.getCep(),
				er.getCidade(), er.getEstado(), cp);
		System.out.println("Id do endereço ************ " + e.getId());
		itemPedidoRepository.saveAll(obj.getItens());
		pedidoClienteRepository.save(cp);
		enderecoRepository.save(e);
		return obj;
	}

	public Optional<Pedido> findById(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj;
	}

	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return pedidoRepository.findAll(pageRequest);
	}

}
