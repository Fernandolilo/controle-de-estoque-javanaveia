package br.com.javanaveia.sales.repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.domain.dto.ItemPedidoDTO;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {


	@Query("SELECT p FROM ItemPedido p WHERE p.nome LIKE %:nome%")
	List<ItemPedidoDTO>findByNomeLike(@Param("nome") String nome);
}
