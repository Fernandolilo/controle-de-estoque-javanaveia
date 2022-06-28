package br.com.javanaveia.client.domain.DTO;

import java.io.Serializable;

public class CredencialDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	public CredencialDTO() {
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
