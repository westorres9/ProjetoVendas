package com.devsuperior.vendas.dto;

import java.io.Serializable;

import com.devsuperior.vendas.entities.Team;

public class TeamDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long userId;
	
	public TeamDTO() {
	}

	public TeamDTO(Long id, String name, Long userId) {
		this.id = id;
		this.name = name;
		this.userId = userId;
	}
	
	public TeamDTO(Team entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.userId = entity.getManager().getId();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
