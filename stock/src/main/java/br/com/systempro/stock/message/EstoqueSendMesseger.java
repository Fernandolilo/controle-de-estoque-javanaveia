package br.com.systempro.stock.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import br.com.systempro.stock.domain.dto.CategoriaDTO;
import br.com.systempro.stock.domain.dto.ProdutoDTO;

@Component
public class EstoqueSendMesseger {
	

	public static final String ESTOQUE_EXCHANGE = "estoque.exchange";

	public static final String ROUTING_kEY = "estoque.#";
	
	public final RabbitTemplate rabbitTemplate;

	
	public EstoqueSendMesseger(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessageCategory(CategoriaDTO categoriaDTO) {
		rabbitTemplate.convertAndSend(ESTOQUE_EXCHANGE, ROUTING_kEY, categoriaDTO);
	}
	

	public void sendMessageProduct(ProdutoDTO produtoDTO) {
		rabbitTemplate.convertAndSend(ESTOQUE_EXCHANGE, ROUTING_kEY, produtoDTO);
	}
}
