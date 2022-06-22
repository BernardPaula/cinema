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

import com.bernardpaula.cinema.domain.Filme;
import com.bernardpaula.cinema.repositories.FilmeRepository;
import com.bernardpaula.cinema.services.exceptions.DataIntegrityException;
import com.bernardpaula.cinema.services.exceptions.ObjectNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repo;
	
	
	public Filme find(Integer id) {
		Optional<Filme> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + " Tipo: " + obj.getClass().getName()));
	}
	
	public List<Filme> findAll(){
		return repo.findAll();
	}
	
	public Filme insert(Filme obj) {
		try {
			obj = repo.save(obj);
			return find(obj.getId());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
		
	public Filme update(Filme obj) {
		Filme newObj = find(obj.getId());
		if(newObj != null) {
			repo.save(obj);
			return find(obj.getId());
		}
		return null;
		}
	
	public void delete(Integer id) {
		try {
			Filme newObj = find(id);
			if(newObj != null) {
				repo.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Entidade não encontrada");
		}
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não foi possível excluir Filme");
		}
	}
	
	public Page<Filme> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Filme> filtrar(String pesquisa){
		List<Filme> list = repo.filtrar(pesquisa);
		return list;
	}
		
}
