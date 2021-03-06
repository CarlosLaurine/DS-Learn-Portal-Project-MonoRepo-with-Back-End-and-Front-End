package com.devsuperior.dslearnbds.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dslearnbds.services.exceptions.DBException;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenAccessException;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedAccessException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {

		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;

		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Resource not Found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(error);

	}

	@ExceptionHandler(DBException.class)
	public ResponseEntity<StandardError> dataBaseException(DBException e, HttpServletRequest request) {

		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST;

		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Database Exception");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());

		return ResponseEntity.status(status).body(error);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidationError error = new ValidationError();
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Validation Exception");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());

		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {

			error.addError(fieldError.getField(), fieldError.getDefaultMessage());

		}

		return ResponseEntity.status(status).body(error);

	}
	
	@ExceptionHandler(UnauthorizedAccessException.class)
	public ResponseEntity<OAuthStandardError> unauthorizedAccess(UnauthorizedAccessException e, HttpServletRequest request) {

		OAuthStandardError error = new OAuthStandardError("Unahuthorized Access", e.getMessage());

		HttpStatus status = HttpStatus.UNAUTHORIZED;

		return ResponseEntity.status(status).body(error);

	}

	@ExceptionHandler(ForbiddenAccessException.class)
	public ResponseEntity<OAuthStandardError> forbiddenAccess(ForbiddenAccessException e, HttpServletRequest request) {

		OAuthStandardError error = new OAuthStandardError("Forbidden Access", e.getMessage());

		HttpStatus status = HttpStatus.FORBIDDEN;

		return ResponseEntity.status(status).body(error);

	}
}