package com.bernardpaula.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bernardpaula.cinema.domain.Sessao;
import com.bernardpaula.cinema.repositories.SessaoRepository;
import com.bernardpaula.cinema.services.exceptions.DataIntegrityException;
import com.bernardpaula.cinema.services.exceptions.ObjectNotFoundException;

@Service
public class SessaoService {

	@Autowired
	private SessaoRepository repo;
	
	
	public Sessao find(Integer id) {
		Optional<Sessao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + Sessao.class.getName()));
	}
	
	public List<Sessao> findAll(){
		return repo.findAll();
	}
	
	public Sessao insert(Sessao obj) {
		try {
			obj = repo.save(obj);
			return find(obj.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Sessao update(Sessao obj) {
		Sessao newObj = find(obj.getId());
		if(newObj != null) {
			repo.save(obj);
			return find(obj.getId());
		} 
		return null;
	}
	
	public void delete(Integer id) {
		try {
			Sessao newObj = find(id);
			if(newObj != null) {
				repo.deleteById(id);
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrado!");
			}		
		} catch(ObjectNotFoundException e) {
			throw new DataIntegrityException("Não foi possível excluir Sessao");
		}
	}
	
	public Page<Sessao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
