package br.com.systempro.stock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.systempro.stock.domain.Produto;
import br.com.systempro.stock.domain.dto.ProdutoDTO;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{	
	
	//List<ProdutoDTO> findByNomeContainingIgnoreCase(String nome);
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	List<ProdutoDTO>findByNomeLike(@Param("nome") String nome);
	
}
