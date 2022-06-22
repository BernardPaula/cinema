package com.bernardpaula.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.cinema.domain.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

	@Query(value = "SELECT * FROM filme WHERE titulo LIKE %:pesquisa%", nativeQuery = true)
	List<Filme> filtrar(@Param("pesquisa") String pesquisa);

}
