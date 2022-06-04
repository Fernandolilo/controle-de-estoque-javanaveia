package br.com.systempro.stock.domain.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.systempro.stock.domain.Fornecedor;

public class FornecedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String empresa;
	private String nomeContato;
	@Email
	private String email;
	@CNPJ
	private String cnpj;
	private String endereço;

	private Set<String> telefones = new HashSet<>();

	public FornecedorDTO() {
	}

	public FornecedorDTO(Fornecedor obj) {
		id = obj.getId();
		empresa = obj.getEmpresa();
		nomeContato = obj.getNomeContato();
		email = obj.getEmail();
		cnpj = obj.getCnpj();
		endereço = obj.getEndereço();
		telefones = obj.getTelefones();
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
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the nomeContato
	 */
	public String getNomeContato() {
		return nomeContato;
	}

	/**
	 * @param nomeContato the nomeContato to set
	 */
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
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
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the endereço
	 */
	public String getEndereço() {
		return endereço;
	}

	/**
	 * @param endereço the endereço to set
	 */
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	/**
	 * @return the telefones
	 */
	public Set<String> getTelefones() {
		return telefones;
	}

	/**
	 * @param telefones the telefones to set
	 */
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
}
