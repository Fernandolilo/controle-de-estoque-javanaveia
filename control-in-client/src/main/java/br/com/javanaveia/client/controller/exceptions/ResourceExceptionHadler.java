package br.com.javanaveia.client.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.javanaveia.client.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHadler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ojectNotFound(
			ObjectNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError
				(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
