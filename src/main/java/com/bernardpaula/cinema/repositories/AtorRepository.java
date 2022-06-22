package com.bernardpaula.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.cinema.domain.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {
	
	@Query(value = "SELECT * FROM ator WHERE nome LIKE %:pesquisa%", nativeQuery=true)
	List<Ator> filtrar(@Param("pesquisa") String pesquisa);
	
}
