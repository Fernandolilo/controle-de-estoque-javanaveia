package br.com.systempro.stock.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.systempro.stock.domain.Categoria;
import br.com.systempro.stock.domain.dto.CategoriaDTO;
import br.com.systempro.stock.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "Categorias endpoint")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private final CategoriaService service;

	@Autowired
	public CategoriaController(CategoriaService service) {
		this.service = service;
	}

	@Operation(summary =  "FIND a specific categories")
	@RequestMapping(value = "/page", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String name) {

		Page<Categoria> list = service.findPage(page, linesPerPage, name, direction);

		Page<CategoriaDTO> listDTO = list.map(obj -> new CategoriaDTO(obj));

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> lista = service.findAll();
		List<CategoriaDTO>listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}


	@Operation(summary =  "FIND a specific categories by id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@Operation(summary =  "PUT a specific categories by id")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Long id) {
		Categoria obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	

	@Operation(summary =  "POST a specific categories")
	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto){
		Categoria obj = service.fromDTO(objDto);
		obj =service.insert(obj);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

	@Operation(summary =  "DELETE a specific categories")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
