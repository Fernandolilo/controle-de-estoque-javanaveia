package br.com.javanaveia.sales.messege;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

	public static final String ESTOQUE_EXCHANGE = "estoque.exchange";

	public static final String ESTOQUE_QUEUE_CATEGORY = "category.queue";

	public static final String ESTOQUE_QUEUE_PRODUCT = "product.queue";

	public static final String ROUTING_KEY_CATEGORY = "estoque.category";
	public static final String ROUTING_KEY_PRODUCT = "estoque.product";

	@Bean
	public Queue queueCategory() {
		return new Queue(ESTOQUE_QUEUE_CATEGORY, true);
	}

	@Bean
	public Queue queueProduto() {
		return new Queue(ESTOQUE_QUEUE_PRODUCT, true);
	}
	
	
	@Bean
	public Exchange declareExchange() {
		return ExchangeBuilder.topicExchange(ESTOQUE_EXCHANGE).durable(true).build();
	}

	@Bean
	public Binding bindingCategory() {
		TopicExchange exchange = new TopicExchange(ESTOQUE_EXCHANGE);
		Queue queue = new Queue(ESTOQUE_QUEUE_CATEGORY, true);
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_CATEGORY);
	}

	@Bean
	public Binding bindingProduto() {
		TopicExchange exchange = new TopicExchange(ESTOQUE_EXCHANGE);
		Queue queue = new Queue(ESTOQUE_QUEUE_PRODUCT, true);
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_PRODUCT);
	}

	

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
