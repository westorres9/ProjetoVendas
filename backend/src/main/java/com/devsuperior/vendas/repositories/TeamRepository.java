package com.devsuperior.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.vendas.entities.Team;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

}
