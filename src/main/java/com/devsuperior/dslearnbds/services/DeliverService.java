package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.entities.Deliver;
import com.devsuperior.dslearnbds.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository repository;

	@Transactional

	@PreAuthorize("hasAnyRole('INSTRUCTOR','ADMIN')")
	public void saveRevision(Long id, DeliverRevisionDTO dto) {

		Deliver deliver = repository.getOne(id);

		deliver.setCorrectCount(dto.getCorrectCount());
		deliver.setStatus(dto.getStatus());
		deliver.setFeedback(dto.getFeedback());

		repository.save(deliver);
	}
}
