package com.devsuperior.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.vendas.dto.TeamDTO;
import com.devsuperior.vendas.dto.TeamInsertDTO;
import com.devsuperior.vendas.entities.Team;
import com.devsuperior.vendas.entities.User;
import com.devsuperior.vendas.repositories.TeamRepository;
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
	public TeamDTO insert(TeamInsertDTO dto) {
		User user = authService.authenticated();
		if(user.hasRole("ROLE_ADMIN")) {
			Team entity = new Team();
			entity.setName(dto.getName());
			entity.setManager(dto.getManager());
			entity = repository.save(entity);
			return new TeamDTO(entity);
		}
		else {
			throw new UnauthorizedException("Unauthorized user");
		}
	}

}
