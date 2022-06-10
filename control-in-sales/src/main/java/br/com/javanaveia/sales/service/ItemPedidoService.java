package br.com.javanaveia.sales.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.repositoryes.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	private final ItemPedidoRepository repository;

	@Autowired
	public ItemPedidoService(ItemPedidoRepository repository) {
		this.repository = repository;
	}
		
	public Optional<ItemPedido> findById(Long id) {
		Optional<ItemPedido> obj = repository.findById(id);
		return obj;
	}

}
