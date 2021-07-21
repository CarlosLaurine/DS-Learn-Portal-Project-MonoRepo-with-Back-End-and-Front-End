package com.devsuperior.dslearnbds.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	Page<Notification> findByUser(User user, Pageable pageable);
	
	@Query("SELECT notification FROM Notification notification WHERE "
	        + "(notification.user = :user) AND "
	        + "(:unreadOnly = false OR notification.read = false) "
	        + "ORDER BY notification.moment ASC")
	Page<Notification> searchAllOrUnread(Pageable pageable, User user, boolean unreadOnly);
}
