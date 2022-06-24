package br.com.javanaveia.produto.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.produto.domain.Venda;
import br.com.javanaveia.produto.proxi.ProdutoProxi;
import br.com.javanaveia.produto.repository.VendaRepository;
import br.com.javanaveia.produto.responseClient.Produto;

@Service
public class VendaService {

	private final VendaRepository repository;
	private final ProdutoProxi proxi;

	@Autowired
	public VendaService(VendaRepository repository, ProdutoProxi proxi) {
		this.repository = repository;
		this.proxi = proxi;
	}
	
	public Optional<Venda> findById(Long id) {
		Optional<Venda> obj = repository.findById(id);
		return obj;
	}

	
	public Venda create(Venda obj) {
		obj.setId(null);
		obj.setInstante(LocalDateTime.now());
		Produto prod = proxi.findById(obj.getIdProduto());
		obj.setIdProduto(obj.getIdProduto());
		obj.setNome(prod.getNome());
		obj.setMarca(prod.getMarca());
		obj.setDescricao(prod.getDescricao());
		obj.setPrecoVenda(prod.getPrecoVenda());
		obj.setQuantidade(obj.getQuantidade());
		return obj = repository.save(obj);
	}

		
	
	
}
