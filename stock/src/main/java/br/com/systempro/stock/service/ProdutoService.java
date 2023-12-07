package br.com.systempro.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.systempro.stock.domain.Produto;
import br.com.systempro.stock.domain.dto.ProdutoDTO;
import br.com.systempro.stock.message.EstoqueSendMesseger;
import br.com.systempro.stock.repositories.ProdutoRepository;
import br.com.systempro.stock.service.exceptions.DataIntegrityViolation;
import br.com.systempro.stock.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository repository;

	private final EstoqueSendMesseger estoqueSendMesseger;

	@Autowired
	public ProdutoService(ProdutoRepository repository, EstoqueSendMesseger estoqueSendMesseger) {
		this.repository = repository;
		this.estoqueSendMesseger = estoqueSendMesseger;
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
		ProdutoDTO prod = new ProdutoDTO(newObj);
		estoqueSendMesseger.sendMessageProduct(prod);
		return repository.save(newObj);
	}

	// este é o cod de update blz

	private void updateData(Produto newObj, Produto obj) {
		newObj.setId(obj.getId());
		newObj.setPreco(obj.getPreco());
		newObj.setDescricao(obj.getDescricao());
		newObj.setMarca(obj.getMarca());
		newObj.setMargem(obj.getMargem());
		newObj.setPreco(obj.getPreco());
		newObj.setNome(obj.getNome());
		newObj.setPrecoVenda(obj.getPrecoVenda());
		newObj.setCategoria(obj.getCategoria());

	}

	public Produto fromDTO(ProdutoDTO objDto) {		
		Produto produto = new Produto(objDto.getId(), objDto.getNome(), objDto.getMarca(), objDto.getDescricao(),
				objDto.getPreco(), objDto.getMargem(), objDto.getPrecoVenda(), objDto.getQuantidade(),
				objDto.getCategoria());
		estoqueSendMesseger.sendMessageProduct(objDto);
		return produto;
	}

	public Produto insert(Produto obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		
		try {
			if (findById(id) != null) {
				ProdutoDTO prod = new ProdutoDTO(id);
				estoqueSendMesseger.sendMessageProduct(prod);
			}
				repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolation("Não é possivel excluir uma categoria que possua produtos.");
		}
		repository.deleteById(id);
	}

}
