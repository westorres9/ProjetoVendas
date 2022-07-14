package com.devsuperior.vendas.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.vendas.dto.SaleDTO;
import com.devsuperior.vendas.entities.Sale;
import com.devsuperior.vendas.repositories.SaleRepository;
import com.devsuperior.vendas.services.exceptions.DatabaseException;
import com.devsuperior.vendas.services.exceptions.ResourceNotFoundException;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		Page<Sale> page = repository.findAll(pageable);
		return page.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public SaleDTO findById(Long id) {
		Optional<Sale> obj = repository.findById(id);
		Sale entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new SaleDTO(entity);
	}
	
	@Transactional
	public SaleDTO insert(SaleDTO dto) {
		Sale entity = new Sale();
		entity.setVisited(dto.getVisited());
		entity.setDeals(dto.getDeals());
		entity.setAmount(dto.getAmount());
		entity.setDate(dto.getDate());
		entity = repository.save(entity);
		return new SaleDTO(entity);
	}
	
	@Transactional
	public SaleDTO update(Long id, SaleDTO dto) {
		try {
			Sale entity = repository.getOne(id);
			entity.setVisited(dto.getVisited());
			entity.setDeals(dto.getDeals());
			entity.setAmount(dto.getAmount());
			entity.setDate(dto.getDate());
			entity = repository.save(entity);
			return new SaleDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found" + id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found" + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}
}
