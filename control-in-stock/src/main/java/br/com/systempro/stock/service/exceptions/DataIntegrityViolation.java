package br.com.systempro.stock.service.exceptions;

public class DataIntegrityViolation  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolation(String msg) {
		super(msg);
	}
	
	public DataIntegrityViolation(String msg, Throwable cause) {
		super(msg, cause);
	}

}
