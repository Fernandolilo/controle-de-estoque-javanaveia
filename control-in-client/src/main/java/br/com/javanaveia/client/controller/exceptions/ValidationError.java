package br.com.javanaveia.client.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
		super(timeStamp, status, error, message, path);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the errors
	 */
	public List<FieldMessage> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void addErrors(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
