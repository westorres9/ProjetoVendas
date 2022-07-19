package com.devsuperior.vendas.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.vendas.dto.TeamDTO;
import com.devsuperior.vendas.entities.Team;
import com.devsuperior.vendas.entities.User;
import com.devsuperior.vendas.repositories.TeamRepository;
import com.devsuperior.vendas.services.exceptions.DatabaseException;
import com.devsuperior.vendas.services.exceptions.ResourceNotFoundException;
import com.devsuperior.vendas.services.exceptions.UnauthorizedException;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	@Autowired
    private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<TeamDTO> teamsOfCurrentManager(Pageable pageable) {
		User user = authService.authenticated();
		if(user.getAuthorities().equals("ROLE_MANAGER")) {
			Page<Team> page = repository.findByManager(user, pageable);
			return page.map(x -> new TeamDTO(x));
		}
		else if (user.getAuthorities().equals("ROLE_ADMIN")){
			Page<Team> page = repository.findAll(pageable);
			return page.map(x -> new TeamDTO(x));
		}
		else {
			throw new UnauthorizedException("Unauthorized user");
		}
		
	}
	
	@Transactional
	public TeamDTO insert(TeamDTO dto) {
		User user = authService.authenticated();
		if(user.getId() == dto.getId() || user.hasRole("ROLE_ADMIN")) {
			Team entity = new Team();
			entity.setName(dto.getName());
			entity.getManager().setId(dto.getUserId());;
			entity = repository.save(entity);
			return new TeamDTO(entity);
		}
		else {
			throw new UnauthorizedException("Unauthorized user");
		}
	}
	
	@Transactional
	public TeamDTO update(Long id, TeamDTO dto) {
		User user = authService.authenticated();
		if (user.getId() == dto.getId() || user.hasRole("ROLE_ADMIN")) {
			try {
				Team entity = repository.getOne(id);
				entity.setName(dto.getName());
				entity.getManager().setId(dto.getUserId());;
				entity = repository.save(entity);
				return new TeamDTO(entity);
			} catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException("Id not found" + id);
			}
		}
		throw new UnauthorizedException("Unauthorized Operation");
	}
	
	public void delete(Long id) {	
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
