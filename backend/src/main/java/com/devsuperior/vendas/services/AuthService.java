package com.devsuperior.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.vendas.entities.User;
import com.devsuperior.vendas.repositories.UserRepository;
import com.devsuperior.vendas.services.exceptions.ForbiddenException;
import com.devsuperior.vendas.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		}
		catch (Exception e) {
			throw new UnauthorizedException("Unauthorized User");
		}
	}
	
	public void validateSelf(Long userId) {
		User user = authenticated();
		if(!user.getId().equals(userId)) {
			throw new ForbiddenException("Access denied"); 
		}
}
	
	public void validateSelfOrAdmin(Long userId) {
			User user = authenticated();
			if(!user.getId().equals(userId) && (!user.hasRole("ROLE_ADMIN"))) {
				throw new ForbiddenException("Access denied"); 
			}
	}
	
	public void validateAdmin(Long userId) {
		User user = authenticated();
		if((!user.hasRole("ROLE_ADMIN"))) {
			throw new ForbiddenException("Access denied"); 
		}
}
}
