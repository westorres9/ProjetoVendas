package com.devsuperior.vendas.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
    public ResponseEntity<TeamDTO> insert(@RequestBody @Valid TeamDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TeamDTO> update(@PathVariable Long id, @RequestBody @Valid TeamDTO dto) {
        TeamDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
	

}
