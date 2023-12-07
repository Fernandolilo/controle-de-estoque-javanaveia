package br.com.systempro.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.systempro.stock.domain.Categoria;
import br.com.systempro.stock.domain.dto.CategoriaDTO;
import br.com.systempro.stock.message.EstoqueSendMesseger;
import br.com.systempro.stock.repositories.CategoriaRepository;
import br.com.systempro.stock.service.exceptions.DataIntegrityViolation;
import br.com.systempro.stock.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	private final CategoriaRepository repository;
	private final EstoqueSendMesseger estoqueSendMesseger;

	@Autowired
	public CategoriaService(CategoriaRepository repository, EstoqueSendMesseger estoqueSendMesseger) {
		this.repository = repository;
		this.estoqueSendMesseger = estoqueSendMesseger;
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID: " + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria update(Categoria obj) {
		Categoria newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setName(obj.getName());
	}

	public Categoria fromDTO(CategoriaDTO objDto) {
		estoqueSendMesseger.sendMessageCategory(objDto);
		return new Categoria(objDto.getId(), objDto.getName());
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Long id) {
		findById(id);
		try {
			if (findById(id) != null) {
				CategoriaDTO cat = new CategoriaDTO(id, null);
				estoqueSendMesseger.sendMessageCategory(cat);
			}
				repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolation("Não é possivel excluir uma categoria que possua produtos.");
		}

	}

}
