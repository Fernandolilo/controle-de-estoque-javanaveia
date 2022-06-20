package br.com.javanaveia.sales.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.javanaveia.sales.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
