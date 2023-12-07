package br.com.javanaveia.sales.domain.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.javanaveia.sales.response.EnderecoResponse;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpfOuCnpj;

	private List<EnderecoResponse> enderecos = new ArrayList<>();

	public Client() {
	}

	public Client(Long id, String nome, String email, String cpfOuCnpj) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * @return the cpfOuCnpj
	 */
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	/**
	 * @param cpfOuCnpj the cpfOuCnpj to set
	 */
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	/**
	 * @return the enderecos
	 */
	public List<EnderecoResponse> getEnderecos() {
		return enderecos;
	}

	/**
	 * @param enderecos the enderecos to set
	 */
	public void setEnderecos(List<EnderecoResponse> enderecos) {
		this.enderecos = enderecos;
	}

}
