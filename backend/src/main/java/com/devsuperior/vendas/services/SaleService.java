package com.devsuperior.vendas.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.vendas.dto.SaleDTO;
import com.devsuperior.vendas.entities.Sale;
import com.devsuperior.vendas.entities.User;
import com.devsuperior.vendas.repositories.SaleRepository;
import com.devsuperior.vendas.services.exceptions.DatabaseException;
import com.devsuperior.vendas.services.exceptions.ResourceNotFoundException;
import com.devsuperior.vendas.services.exceptions.UnauthorizedException;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public Page<SaleDTO> salesBySeller(Pageable pageable) {
		User user = authService.authenticated();

		if (user.hasRole("ROLE_ADMIN")) {
			Page<Sale> page = repository.findAll(pageable);
			return page.map(x -> new SaleDTO(x));
		} else {
			Page<Sale> page = repository.findBySeller(user, pageable);
			return page.map(x -> new SaleDTO(x));
		}
	}

	@Transactional
	public SaleDTO insert(SaleDTO dto) {
		User user = authService.authenticated();
		if (user.getId() == dto.getId()) {
			Sale entity = new Sale();
			entity.setAmount(dto.getAmount());
			entity.setDate(dto.getDate());
			entity.setVisited(dto.getVisited());
			entity.setDeals(dto.getDeals());
			entity.getSeller().setId(dto.getUserId());
			entity = repository.save(entity);
			return new SaleDTO(entity);
		}
		throw new UnauthorizedException("Unauthorized Operation");
	}

	@Transactional
	public SaleDTO update(Long id, SaleDTO dto) {
		User user = authService.authenticated();
		if (user.getId() == dto.getId()) {
			try {
				Sale entity = repository.getOne(id);
				entity.setAmount(dto.getAmount());
				entity.setDate(dto.getDate());
				entity.setVisited(dto.getVisited());
				entity.setDeals(dto.getDeals());
				entity.getSeller().setId(dto.getUserId());
				entity = repository.save(entity);
				return new SaleDTO(entity);
			} catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException("Id not found" + id);
			}
		}
		throw new UnauthorizedException("Unauthorized Operation");
	}
	
	public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
