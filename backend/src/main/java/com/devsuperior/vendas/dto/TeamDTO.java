package com.devsuperior.vendas.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devsuperior.vendas.entities.Seller;
import com.devsuperior.vendas.entities.Team;

public class TeamDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private List<SellerDTO> sellers = new ArrayList<>();
	
	public TeamDTO() {
	}

	public TeamDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public TeamDTO(Team entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	public TeamDTO(Team entity, Set<Seller> sellers) {
		this(entity);
		sellers.forEach(sel -> this.sellers.add(new SellerDTO(sel)));
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

	public List<SellerDTO> getSellers() {
		return sellers;
	}
	
	

}
