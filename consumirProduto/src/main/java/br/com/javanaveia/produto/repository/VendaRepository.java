package br.com.javanaveia.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.javanaveia.produto.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

}
