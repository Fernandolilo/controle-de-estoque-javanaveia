package br.com.systempro.stock.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systempro.stock.domain.Categoria;
import br.com.systempro.stock.domain.Fornecedor;
import br.com.systempro.stock.domain.Produto;
import br.com.systempro.stock.repositories.CategoriaRepository;
import br.com.systempro.stock.repositories.ForneceforRepository;
import br.com.systempro.stock.repositories.ProdutoRepository;

@Service
public class DBService {
	
	private final CategoriaRepository categoriaRepository;
	private final ProdutoRepository produtoRepository;
	private final ForneceforRepository forneceforRepository;
	
	@Autowired
	public DBService(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
			ForneceforRepository forneceforRepository) {
		this.categoriaRepository = categoriaRepository;
		this.produtoRepository = produtoRepository;
		this.forneceforRepository = forneceforRepository;
	}
	
	public void instantiateDatabase() {
		
		Categoria cat1 = new Categoria(null, "Ferramentas");
		Categoria cat2 = new Categoria(null, "Informatica");
		Categoria cat3 = new Categoria(null, "Eletrônicos");
		
		Fornecedor f1 = new Fornecedor(null, "Com de ferramentas", "Fernando Silva","fer@gmail.com", "90718545000120", "Rua serra1, N15, Bairro Vl Céu, São Paulo SP");
		f1.getTelefones().addAll(Arrays.asList("11 123456789", "11 78974444", "11 9 12345678"));
		
		Fornecedor f2 = new Fornecedor(null, "Com geral", "Fernando Silva", "fer@gmail.com", "90718545000120", "Rua serra1, N15, Bairro Vl Céu, São Paulo SP");
		f1.getTelefones().addAll(Arrays.asList("11 123456789", "11 78974444", "11 9 12345678"));
		
		Fornecedor f3 = new Fornecedor(null, "Com de Eletronicos", "Fernando Silva", "fer@gmail.com", "90718545000120", "Rua serra1, N15, Bairro Vl Céu, São Paulo SP");
		f1.getTelefones().addAll(Arrays.asList("11 123456789", "11 78974444", "11 9 12345678"));
		
		Produto p1 = new Produto(null, "Furadeira","Mondial","127V de impacto", 250.55, 10, cat1, f1);
		Produto p2 = new Produto(null, "Maquita", "Maquita", "220V 3000HP", 351.55, 10, cat1, f1);
		Produto p3 = new Produto(null, "Arco de serra", "Star Rett","Serra de ferro revestido com tinta acrilica", 25.00, 10, cat1, f1);
		Produto p4 = new Produto(null, "Martelo", "ferrero","Martelo universao com cabo de madeira 30cm", 37.55, 10, cat1, f1);
		Produto p5 = new Produto(null, "Impressora","Hp","Impressora a laser", 8000.55, 10, cat2, f2);
		Produto p6 = new Produto(null, "Computador", "Asus","computador com placa de video vega8, processador Rayzen 5 ", 2000.99, 10, cat2, f2);
		Produto p7 = new Produto(null, "Mesa para Computador", "Decorations", "Mesa de mateira, 120cm de largura por 80 de altura, 3 gavetas",199.99, 10, cat2, f2);
		Produto p8 = new Produto(null, "Roteador", "Dlink", "Roteador de 300M com 2 Antenas de 10Dbi", 149.99, 10, cat2, f2);
		Produto p9 = new Produto(null, "fone de ouvido","Shinka", "Fone de ouvidos hard-set com leds, otimo para games", 20.55, 10, cat3, f3);
		Produto p10 = new Produto(null, "Lampada de mesa","Lume", "lampada bocal E27 60W", 49.99, 10, cat3, f3);
		Produto p11 = new Produto(null, "Calculadora cientifica", "Hp","Calculadora finaceira hp", 79.99, 10, cat3, f3);
		Produto p12 = new Produto(null, "Despertador", "Black", "Despertador com calendario",25.55, 10, cat3, f3);
		
		
		
		f1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		f2.getProdutos().addAll(Arrays.asList(p5, p6, p7, p8));
		f3.getProdutos().addAll(Arrays.asList(p9, p10, p11, p12));
		
		/*p1.getFornecedores().add(f1);
		p2.getFornecedores().add(f1);
		p3.getFornecedores().add(f1);
		p4.getFornecedores().add(f1);
		p5.getFornecedores().add(f2);
		p6.getFornecedores().add(f2);
		p7.getFornecedores().add(f2);
		p8.getFornecedores().add(f2);
		p9.getFornecedores().add(f3);
		p10.getFornecedores().add(f3);
		p11.getFornecedores().add(f3);
		p12.getFornecedores().add(f3);*/
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		cat2.getProdutos().addAll(Arrays.asList(p5, p6, p7, p8));
		cat3.getProdutos().addAll(Arrays.asList(p9, p10, p11, p12));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		forneceforRepository.saveAll(Arrays.asList(f1, f2, f3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8,p9, p10, p11, p12 ));
		
		
	}

}
