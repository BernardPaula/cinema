package com.bernardpaula.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bernardpaula.cinema.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

	
}
