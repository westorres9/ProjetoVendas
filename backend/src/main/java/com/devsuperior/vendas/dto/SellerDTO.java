package com.devsuperior.vendas.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devsuperior.vendas.entities.Sale;
import com.devsuperior.vendas.entities.User;

public class SellerDTO {
	
	private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
    private List<SaleDTO> sales = new ArrayList<>();
    
    public SellerDTO() {
    }

	public SellerDTO(Long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public SellerDTO(User entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.email = entity.getEmail();
	}
	
	public SellerDTO(User entity, Set<Sale> sales) {
		this(entity);
		sales.forEach(sale -> this.sales.add(new SaleDTO(sale)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<SaleDTO> getSales() {
		return sales;
	}
    
    
    

}
