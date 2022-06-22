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

import com.bernardpaula.cinema.domain.Ingresso;
import com.bernardpaula.cinema.services.IngressoService;

@RestController
@RequestMapping(value = "/ingressos")
public class IngressoResource {

	@Autowired
	private IngressoService service;
	
	@RequestMapping(value = "/buscar/{id}", method=RequestMethod.GET)
	public ResponseEntity<Ingresso> find(@PathVariable Integer id){
		Ingresso obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/listar", method=RequestMethod.GET)
	public ResponseEntity<List<Ingresso>> findAll(){
		List<Ingresso> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/inserir", method=RequestMethod.POST)
	public ResponseEntity<Ingresso> insert(@RequestBody Ingresso obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/atualizar", method=RequestMethod.PUT)
	public ResponseEntity<Ingresso> update(@RequestBody Ingresso obj){
		Ingresso newObj = service.update(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@RequestMapping(value = "/deletar/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Ingresso>> findPage(
			@RequestParam(value ="page", defaultValue = "0")Integer page,
			@RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value ="orderBy", defaultValue = "id")String orderBy,
			@RequestParam(value ="direction", defaultValue = "ASC")String direction){
		Page<Ingresso> list = service.findPage(page, linesPerPage, orderBy, direction);	
		return ResponseEntity.ok().body(list);
	}
	
}
