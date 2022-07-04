package com.bernardpaula.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.cinema.domain.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Integer> {

	
}
