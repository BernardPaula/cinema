package com.bernardpaula.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernardpaula.cinema.domain.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}
