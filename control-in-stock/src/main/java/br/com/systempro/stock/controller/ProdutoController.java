 package br.com.systempro.stock.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.systempro.stock.domain.Produto;
import br.com.systempro.stock.domain.dto.ProdutoDTO;
import br.com.systempro.stock.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "Produtos endpoit")
@RestController
@CrossOrigin
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService service;

	@Autowired
	public ProdutoController(ProdutoService service) {
		this.service = service;
	}

	@Operation(summary = "FindPage Produtos")
	@RequestMapping(value = "/page",produces = { "application/json", "application/xml", "application/yaml" }, method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String nome) {

		Page<Produto> list = service.findPage(page, linesPerPage, nome, direction);
		Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

	

	@Operation(summary = "FindById Produtos")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@Operation(summary = "FindByName Produtos")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<ProdutoDTO> findByName(@RequestParam(name = "nome", required = true) String nome){
		List<ProdutoDTO> list = service.findByName(nome);
		return list;
	}
	
	@Operation(summary = "PUT Produtos")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProdutoDTO objDto, @PathVariable Long id) {
		Produto obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "POST Produtos")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoDTO objDto) {
		Produto obj = service.fromDTO(objDto);
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@Operation(summary = "DELETE Produtos")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
