package br.com.systempro.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systempro.stock.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
