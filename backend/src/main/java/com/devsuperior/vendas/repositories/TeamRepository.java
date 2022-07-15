package com.devsuperior.vendas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.vendas.entities.Team;
import com.devsuperior.vendas.entities.User;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
	Page<Team> findByManager(User manager, Pageable pageable);

}
