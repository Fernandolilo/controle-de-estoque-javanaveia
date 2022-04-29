package br.com.systempro.stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.systempro.stock.domain.Produto;
import br.com.systempro.stock.domain.dto.ProdutoDTO;
import br.com.systempro.stock.repositories.ProdutoRepository;
import br.com.systempro.stock.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository repository;
	private final CategoriaService categoriaService; 

	@Autowired
	public ProdutoService(ProdutoRepository repository, CategoriaService categoriaService) {
		this.repository = repository;
		this.categoriaService = categoriaService;
	}

	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException(
						"Objeto não encontrado ID: " + ", Tipo: " + Produto.class.getName()));
	}

	public Produto update(Produto obj) {
		Produto newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Produto newObj, Produto obj) {
		newObj.setPreco(obj.getPreco());
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getPreco(), objDto.getQuantidade(),
				objDto.getCategoria());
	}

	public Produto insert(Produto obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
