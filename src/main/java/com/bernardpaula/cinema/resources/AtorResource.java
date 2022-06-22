package com.bernardpaula.cinema.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bernardpaula.cinema.domain.Ator;
import com.bernardpaula.cinema.services.AtorService;

@RestController
@RequestMapping(value = "/atores")
public class AtorResource {

	@Autowired
	private AtorService service;
	
	@RequestMapping(value = "/buscar/{id}", method=RequestMethod.GET)
	public ResponseEntity<Ator> find(@PathVariable Integer id){
		Ator obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Ator>> findAll(){
		List<Ator> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Ator> insert(@RequestBody Ator obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/atualizar", method=RequestMethod.PUT)
	public ResponseEntity<Ator> update(@RequestBody Ator obj){
		Ator newObj = service.update(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@RequestMapping(value = "/deletar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/page",  method=RequestMethod.GET)
	public ResponseEntity<Page<Ator>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page,
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value ="orderBy", defaultValue = "nome")String orderBy,
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<Ator> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/filtrar/{pesquisa}",  method=RequestMethod.GET)
	public ResponseEntity<List<Ator>> filtrar(@PathVariable String pesquisa){
		List<Ator> list = service.filtrar(pesquisa);
		return ResponseEntity.ok().body(list);
	}
}
