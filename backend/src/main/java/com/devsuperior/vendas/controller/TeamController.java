package com.devsuperior.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.vendas.dto.TeamDTO;
import com.devsuperior.vendas.services.TeamService;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {
	
	@Autowired
	private TeamService service;
	
	@GetMapping
	public ResponseEntity<Page<TeamDTO>> teamsForCurrentManager(Pageable pageable) {
		Page<TeamDTO> page = service.teamsOfCurrentManager(pageable);
		return ResponseEntity.ok().body(page);
	}
	

}
