package br.com.systempro.stock.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import br.com.systempro.stock.domain.dto.CategoriaDTO;
import br.com.systempro.stock.domain.dto.ProdutoDTO;

@Component
public class EstoqueSendMesseger {
	

	public static final String ESTOQUE_EXCHANGE = "estoque.exchange";
	

    public static final String ROUTING_KEY_CATEGORY = "estoque.category";
    public static final String ROUTING_KEY_PRODUCT = "estoque.product";
	
	public final RabbitTemplate rabbitTemplate;

	
	public EstoqueSendMesseger(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessageCategory(CategoriaDTO categoria) {
		rabbitTemplate.convertAndSend(ESTOQUE_EXCHANGE, ROUTING_KEY_CATEGORY, categoria);
	}
	
	
	public void sendMessageProduct(ProdutoDTO produtoDTO) {
		rabbitTemplate.convertAndSend(ESTOQUE_EXCHANGE, ROUTING_KEY_PRODUCT, produtoDTO);
	}

	
}
