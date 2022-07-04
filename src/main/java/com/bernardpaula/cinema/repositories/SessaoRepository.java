package com.bernardpaula.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.cinema.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

	
}
