package br.com.javanaveia.sales.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.javanaveia.sales.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
