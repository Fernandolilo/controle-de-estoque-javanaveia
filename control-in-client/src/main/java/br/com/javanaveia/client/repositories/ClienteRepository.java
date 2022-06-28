package br.com.javanaveia.client.repositories;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.javanaveia.client.domain.Cliente;
import br.com.javanaveia.client.domain.DTO.ClienteDTO;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
	List<ClienteDTO> findByNome(String nome);
	
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
	
}
