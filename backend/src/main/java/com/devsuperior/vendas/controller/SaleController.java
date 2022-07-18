package com.devsuperior.vendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.vendas.dto.SaleDTO;
import com.devsuperior.vendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> salesBySeller(Pageable pageable) {
		Page<SaleDTO> page = service.salesBySeller(pageable);
		return ResponseEntity.ok().body(page);
	}
	

}
