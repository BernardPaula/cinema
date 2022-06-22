package com.bernardpaula.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bernardpaula.cinema.domain.Ingresso;
import com.bernardpaula.cinema.repositories.IngressoRepository;
import com.bernardpaula.cinema.services.exceptions.DataIntegrityException;
import com.bernardpaula.cinema.services.exceptions.ObjectNotFoundException;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository repo;
	
	
	public Ingresso find(Integer id) {
		Optional<Ingresso> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + Ingresso.class.getName()));
	}
	
	public List<Ingresso> findAll(){
		return repo.findAll();
	}
	
	public Ingresso insert(Ingresso obj) {
		try {
		obj = repo.save(obj);
		return find(obj.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Ingresso update(Ingresso obj) {
		Ingresso newObj = find(obj.getId());
		if(newObj != null) {
			repo.save(obj);
			return find(obj.getId());
		}
		return null;
	}
	
	public void delete (Integer id) {
		try {
			Ingresso obj = find(id);
			if(obj != null) {
				repo.deleteById(id);
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não Encontrada!");
			}
			} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Ingresso");
		}
	}
	
	public Page<Ingresso> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
}
