package com.devsuperior.vendas.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devsuperior.vendas.entities.Sale;
import com.devsuperior.vendas.entities.Seller;

public class SellerDTO {
	
	private Long id;
	private String name;
	private List<SaleDTO> sales = new ArrayList<>();
	
	public SellerDTO() {
	}

	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public SellerDTO(Seller entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}
	
	public SellerDTO(Seller entity, Set<Sale> sales) {
		this(entity);
		sales.forEach(sale -> this.sales.add(new SaleDTO(sale)));
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

	public List<SaleDTO> getSales() {
		return sales;
	}
	
	

}
