package br.com.javanaveia.sales.messege;

import java.util.Optional;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.javanaveia.sales.domain.Produto;
import br.com.javanaveia.sales.domain.dto.ProdutoDTO;
import br.com.javanaveia.sales.repositoryes.ProdutoRepository;

@Component
public class ReceiveMessageProducts {
	private final ProdutoRepository repository;

	@Autowired
	public ReceiveMessageProducts(ProdutoRepository repository) {
		this.repository = repository;
	}

	@RabbitListener(queues = MessageConfig.ESTOQUE_QUEUE_PRODUCT)
	public void receive(@Payload ProdutoDTO product) {
	    try {
	        if (product == null) {
	            // Log or handle the situation when the received product is null
	            return;
	        }

	        if (product.getNome() == null) {
	            delete(product);
	        } else {
	            create(product);
	        }
	    } catch (Exception e) {
	        // Log the exception for debugging purposes
	        // You might want to consider additional error-handling strategies here
	        e.printStackTrace();
	    }
	}


	public ProdutoDTO create(ProdutoDTO product) {
		product.setId(product.getId());
		Produto p = new Produto(product.getId(), product.getNome(), product.getMarca(), product.getDescricao(),
				product.getPreco(), product.getPrecoVenda(), product.getPreco(), product.getQuantidade(),
				product.getCategoria());

		repository.save(p);
		return product;
	}

	public void delete(ProdutoDTO product) {
	    if (product.getId() != null) {
	        Optional<Produto> prod = repository.findById(product.getId());
	        prod.ifPresent(p -> repository.deleteById(product.getId()));
	    }
	}


}
