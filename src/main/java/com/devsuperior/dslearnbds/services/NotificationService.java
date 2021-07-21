package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Autowired
	private AuthorizationService authorizationService;

	@Transactional(readOnly = true)
	public Page<NotificationDTO> findNotificationsForActiveUserPaged(Pageable pageable, boolean unreadOnly) {

		User currentUser = authorizationService.getCurrentAuthenticatedUser();

		Page<Notification> page = repository.searchAllOrUnread(pageable, currentUser, unreadOnly);

		return page.map(notification -> new NotificationDTO(notification));
	}
}
