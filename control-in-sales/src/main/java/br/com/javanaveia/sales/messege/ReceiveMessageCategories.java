package br.com.javanaveia.sales.messege;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.javanaveia.sales.domain.Categoria;
import br.com.javanaveia.sales.repositoryes.CategoriaRepository;

@Component
public class ReceiveMessageCategories {

	private final CategoriaRepository repository;

	public ReceiveMessageCategories(CategoriaRepository repository) {
		this.repository = repository;
	}

	@RabbitListener(queues = MessageConfig.ESTOQUE_QUEUE_CATEGORY)
	public void receiver(@Payload Categoria categoria) {
		if (categoria.getName() == null) {
			delete(categoria);
		} else {
			create(categoria);
		}
	}

	public Categoria create(Categoria categoria) {
		if (categoria.getId() != null) {
			categoria.setId(categoria.getId());
			categoria.setName(categoria.getName());
			repository.save(categoria);
		}
		return repository.save(categoria);
	}

	public void delete(Categoria categoria) {
		Optional<Categoria> cat = repository.findById(categoria.getId());
		if (cat.isPresent()) {
			repository.deleteById(categoria.getId());
		}
	}

}
