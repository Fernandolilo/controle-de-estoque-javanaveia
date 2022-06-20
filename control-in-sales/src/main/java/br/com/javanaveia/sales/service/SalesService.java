package br.com.javanaveia.sales.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javanaveia.sales.domain.Produto;
import br.com.javanaveia.sales.domain.Sales;
import br.com.javanaveia.sales.repositoryes.SalesRepository;
import br.com.javanaveia.sales.response.ProdutoResponse;

@Service
public class SalesService {

	private final SalesRepository repository;
	private final ProdutoResponse response;

	@Autowired
	public SalesService(SalesRepository repository,	ProdutoResponse response) {
		this.repository = repository;
		this.response = response;
	}

	public Sales insert(Sales obj) {
		obj.setId(null);
		obj.setInstante(new Date());		
		Produto pp = response.getProduto(obj.getIdProduto());
		obj.setIdProduto(obj.getIdProduto());
		obj.setNome(pp.getNome());
		obj.setMarca(pp.getMarca());
		obj.setPreco(pp.getPrecoVenda());
		obj.setQuantidade(obj.getQuantidade());
		obj = repository.save(obj);
		

		return obj;
	}

}
