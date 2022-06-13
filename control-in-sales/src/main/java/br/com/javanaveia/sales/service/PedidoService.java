package br.com.javanaveia.sales.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.javanaveia.sales.domain.Client;
import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.domain.Pedido;
import br.com.javanaveia.sales.domain.Cliente;
import br.com.javanaveia.sales.domain.Produto;
import br.com.javanaveia.sales.repositoryes.ItemPedidoRepository;
import br.com.javanaveia.sales.repositoryes.PedidoClienteRepository;
import br.com.javanaveia.sales.repositoryes.PedidoRepository;
import br.com.javanaveia.sales.response.ClienteProxi;
import br.com.javanaveia.sales.response.ProdutoResponse;

@Service
public class PedidoService {

	private final ItemPedidoRepository itemPedidoRepository;
	private final PedidoRepository pedidoRepository;
	private final ProdutoResponse response;
	private final ClienteProxi clienteProxi;
	private final PedidoClienteRepository pedidoClienteRepository;

	@Autowired
	public PedidoService(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository,
			ProdutoResponse response, ClienteProxi clienteProxi, PedidoClienteRepository pedidoClienteRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
		this.pedidoRepository = pedidoRepository;
		this.response = response;
		this.clienteProxi = clienteProxi;
		this.pedidoClienteRepository = pedidoClienteRepository;
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(LocalDateTime.now());
		obj.setIdProduto(obj.getIdProduto());
		obj.setIdCliente(obj.getIdCliente());
		Client cli = clienteProxi.getClienteById(obj.getIdCliente());
		Produto prod = response.getProduto(obj.getIdProduto());
		obj = pedidoRepository.save(obj);
		/*
		 * Cliente cp = new Cliente(null, obj.getIdCliente(), cli.getNome(),
		 * cli.getEmail(), cli.getCpfOuCnpj()); pedidoClienteRepository.save(cp);
		 */
		for (ItemPedido ip : obj.getItens()) {
			if (ip.getId() == null) {
				ip.setIdProduto(prod.getId());
				ip.setMarca(prod.getMarca());
				ip.setNome(prod.getMarca());
				ip.setDescricao(prod.getDescricao());
				ip.setPreco(prod.getPreco());
				ip.setQuantidade(ip.getQuantidade());
				ip.setPedido(obj);
			}

		}
		/*
		 * for(Cliente cp: obj.getClientes()) { cp.setId(null);
		 * cp.setIdCliente(cli.getId()); cp.setNome(cli.getNome());
		 * cp.setEmail(cli.getEmail()); cp.setCpfOuCnpj(cli.getCpfOuCnpj());
		 * cp.setPedido(obj); } pedidoClienteRepository.saveAll(obj.getClientes());
		 */

		Cliente cp = new Cliente(null, obj.getIdCliente(), cli.getNome(), cli.getEmail(), cli.getCpfOuCnpj(), obj);
		pedidoClienteRepository.save(cp);
		itemPedidoRepository.saveAll(obj.getItens());
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
