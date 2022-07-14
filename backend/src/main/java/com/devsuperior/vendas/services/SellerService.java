package com.devsuperior.vendas.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.vendas.dto.SellerDTO;
import com.devsuperior.vendas.entities.Seller;
import com.devsuperior.vendas.repositories.SellerRepository;
import com.devsuperior.vendas.services.exceptions.DatabaseException;
import com.devsuperior.vendas.services.exceptions.ResourceNotFoundException;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SellerDTO> findAll(Pageable pageable) {
		Page<Seller> page = repository.findAll(pageable);
		return page.map(x -> new SellerDTO(x));
	}
	
	@Transactional(readOnly = true)
	public SellerDTO findById(Long id) {
		Optional<Seller> obj = repository.findById(id);
		Seller entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new SellerDTO(entity, entity.getSales());
	}
	
	@Transactional
	public SellerDTO insert(SellerDTO dto) {
		Seller entity = new Seller();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new SellerDTO(entity);
	}
	
	@Transactional
	public SellerDTO update(Long id, SellerDTO dto) {
		try {
			Seller entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new SellerDTO(entity);
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
