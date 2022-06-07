package br.com.javanaveia.sales.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.domain.Pedido;
import br.com.javanaveia.sales.domain.Produto;
import br.com.javanaveia.sales.repositoryes.ItemPedidoRepository;
import br.com.javanaveia.sales.repositoryes.PedidoRepository;
import br.com.javanaveia.sales.response.ProdutoResponse;

@Service
public class PedidoService {

	private final ItemPedidoRepository itemPedidoRepository;
	private final PedidoRepository pedidoRepository;
	private final ProdutoResponse response;

	@Autowired
	public PedidoService(ItemPedidoRepository itemPedidoRepository, PedidoRepository pedidoRepository,
			ProdutoResponse response) {
		this.itemPedidoRepository = itemPedidoRepository;
		this.pedidoRepository = pedidoRepository;
		this.response = response;
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(LocalDateTime.now());
		obj.setIdProduto(obj.getIdProduto());
		Produto prod =  response.getProduto(obj.getIdProduto());
		obj = pedidoRepository.save(obj);
		for (ItemPedido ip : obj.getItens()) {
			if(ip.getId() == null) {
				ip.setIdProduto(prod.getId());
				ip.setMarca(prod.getMarca());
				ip.setNome(prod.getMarca());
				ip.setDescricao(prod.getDescricao());
				ip.setPreco(prod.getPreco());
				ip.setQuantidade(ip.getQuantidade());
				ip.setPedido(obj);
			}			
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
	
	public Optional<Pedido> findById(Long id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj;
	}
	
}
