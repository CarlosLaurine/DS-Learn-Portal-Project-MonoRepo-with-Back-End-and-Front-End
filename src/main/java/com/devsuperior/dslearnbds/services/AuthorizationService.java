package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenAccessException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedAccessException;

@Service
public class AuthorizationService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User getCurrentAuthenticatedUser() {

		try {

			String username = SecurityContextHolder.getContext().getAuthentication().getName();

			User user = userRepository.findByEmail(username);

			return user;

		} catch (Exception e) {

			throw new UnauthorizedAccessException("Invalid User");

		}

	}

	public void validateAdminOrSelfUser(Long userId) {

		User user = getCurrentAuthenticatedUser();

		if (user.getId() != userId && !user.containsThisRole("ROLE_ADMIN")) {

			throw new ForbiddenAccessException("Access Denied");

		}
	}

}
