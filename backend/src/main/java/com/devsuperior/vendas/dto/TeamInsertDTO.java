package com.devsuperior.vendas.dto;

import com.devsuperior.vendas.entities.User;

public class TeamInsertDTO {
	
	private Long id;
	private String name;
	private User manager;
	
	public TeamInsertDTO() {
		
	}

	public TeamInsertDTO(Long id, String name, User manager) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
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

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}
	
	

}
