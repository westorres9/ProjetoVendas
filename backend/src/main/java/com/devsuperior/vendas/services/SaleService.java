package com.devsuperior.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.vendas.dto.SaleDTO;
import com.devsuperior.vendas.entities.Sale;
import com.devsuperior.vendas.entities.User;
import com.devsuperior.vendas.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private AuthService authService;

	public Page<SaleDTO> salesBySeller(Pageable pageable) {
		User user = authService.authenticated();

		if(user.hasRole("ROLE_ADMIN")) {	
			Page<Sale> page = repository.findAll(pageable);
			return page.map(x -> new SaleDTO(x));
		} 
		else  {
			Page<Sale> page = repository.findBySeller(user, pageable);
			return page.map(x -> new SaleDTO(x));
		}
	}

}
