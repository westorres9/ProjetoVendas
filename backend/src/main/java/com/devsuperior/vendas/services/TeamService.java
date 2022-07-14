package com.devsuperior.vendas.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.vendas.dto.TeamDTO;
import com.devsuperior.vendas.entities.Team;
import com.devsuperior.vendas.repositories.TeamRepository;
import com.devsuperior.vendas.services.exceptions.DatabaseException;
import com.devsuperior.vendas.services.exceptions.ResourceNotFoundException;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	@Transactional(readOnly = true)
	public Page<TeamDTO> findAll(Pageable pageable) {
		Page<Team> page = repository.findAll(pageable);
		return page.map(x -> new TeamDTO(x));
	}
	
	@Transactional(readOnly = true)
	public TeamDTO findById(Long id) {
		Optional<Team> obj = repository.findById(id);
		Team entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new TeamDTO(entity, entity.getSellers());
	}
	
	@Transactional
	public TeamDTO insert(TeamDTO dto) {
		Team entity = new Team();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new TeamDTO(entity);
	}
	
	@Transactional
	public TeamDTO update(Long id, TeamDTO dto) {
		try {
			Team entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new TeamDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found" + id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found" + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}
}
