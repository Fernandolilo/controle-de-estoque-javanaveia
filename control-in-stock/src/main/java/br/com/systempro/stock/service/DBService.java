package br.com.systempro.stock.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systempro.stock.domain.Categoria;
import br.com.systempro.stock.domain.Produto;
import br.com.systempro.stock.repositories.CategoriaRepository;
import br.com.systempro.stock.repositories.ProdutoRepository;

@Service
public class DBService {
	
	private final CategoriaRepository categoriaRepository;
	private final ProdutoRepository produtoRepository;

	@Autowired
	public DBService(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
	}
	
	public void instantiateDatabase() {
		
		Categoria cat1 = new Categoria(null, "Ferramentas");
		Categoria cat2 = new Categoria(null, "Informatica");
		Categoria cat3 = new Categoria(null, "Eletrônicos");
		
		
		Produto p1 = new Produto(null, "furadeira","Modial", 250.55, 10, cat1);
		Produto p2 = new Produto(null, "maquita", "Maquita", 351.55, 10, cat1);
		Produto p3 = new Produto(null, "arco de serra", "Star Rett", 25.00, 10, cat1);
		Produto p4 = new Produto(null, "martelo", "ferrero", 37.55, 10, cat1);
		Produto p5 = new Produto(null, "impressora","Hp", 8000.55, 10, cat2);
		Produto p6 = new Produto(null, "computador", "Asus", 2000.99, 10, cat2);
		Produto p7 = new Produto(null, "mesa para computador", "Decorations", 199.99, 10, cat2);
		Produto p8 = new Produto(null, "roteador", "Dlink", 149.99, 10, cat2);
		Produto p9 = new Produto(null, "fone de ouvido","Shinka", 20.55, 10, cat3);
		Produto p10 = new Produto(null, "lampada de mesa","Lume",  49.99, 10, cat3);
		Produto p11 = new Produto(null, "calculadora cientifica", "Hp", 79.99, 10, cat3);
		Produto p12 = new Produto(null, "despertador", "MomBlack", 25.55, 10, cat3);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		cat2.getProdutos().addAll(Arrays.asList(p5, p6, p7, p8));
		cat3.getProdutos().addAll(Arrays.asList(p9, p10, p11, p12));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8,p9, p10, p11, p12 ));
		
	}

}
