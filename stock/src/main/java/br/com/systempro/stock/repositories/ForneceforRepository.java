package br.com.systempro.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systempro.stock.domain.Fornecedor;

@Repository
public interface ForneceforRepository extends JpaRepository<Fornecedor, Long>{

}
