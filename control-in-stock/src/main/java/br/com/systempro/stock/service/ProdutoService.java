package br.com.systempro.stock.service;

import java.util.List;
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

	@Autowired
	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}

	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado ID: " + ", Tipo: " + Produto.class.getName()));
	}

	public List<ProdutoDTO> findByName(String nome) {
		List<ProdutoDTO> produtos = repository.findByNomeLike(nome);
		return produtos;
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
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getMarca(),objDto.getDescricao(), 
				objDto.getPreco(),  objDto.getMargem(), objDto.getPrecoVenda(),
				objDto.getQuantidade(), objDto.getCategoria(), objDto.getFornecedor());

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
