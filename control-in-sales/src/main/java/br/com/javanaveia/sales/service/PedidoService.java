package br.com.javanaveia.sales.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.javanaveia.sales.domain.Client;
import br.com.javanaveia.sales.domain.Cliente;
import br.com.javanaveia.sales.domain.Empresa;
import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.domain.Pedido;
import br.com.javanaveia.sales.domain.Produto;
import br.com.javanaveia.sales.repositoryes.EmpresaRepository;
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
	private final EmpresaRepository empresaRepository;

	@Autowired
	public PedidoService(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository,
			ProdutoResponse response, ClienteProxi clienteProxi, PedidoClienteRepository pedidoClienteRepository,
			EmpresaRepository empresaRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
		this.pedidoRepository = pedidoRepository;
		this.response = response;
		this.clienteProxi = clienteProxi;
		this.pedidoClienteRepository = pedidoClienteRepository;
		this.empresaRepository = empresaRepository;
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(LocalDateTime.now());
		obj.setIdProduto(obj.getIdProduto());
		obj.setIdCliente(obj.getIdCliente());
		Client cli = clienteProxi.getClienteById(obj.getIdCliente());
		Produto prod = response.getProduto(obj.getIdProduto());
		Optional<Empresa> emp = empresaRepository.findById(obj.getEmpresa().getId());
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
		Cliente cp = new Cliente(null, obj.getIdCliente(), cli.getNome(), cli.getEmail(),
				cli.getCpfOuCnpj(), obj);
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
