package br.com.systempro.stock.message;

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

	public static final String ROUTING_KEY = "estoque.#";

	@Bean
	public Queue queue() {
		return new Queue(ESTOQUE_QUEUE_CATEGORY);
	}

	@Bean
	public Binding binding() {
		TopicExchange exchange = new TopicExchange(ESTOQUE_EXCHANGE);
		Queue queue = new Queue(ESTOQUE_QUEUE_CATEGORY);
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	@Bean
	public Exchange declareExchange() {
		return ExchangeBuilder.topicExchange(ESTOQUE_EXCHANGE).durable(true).build();
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	

}
