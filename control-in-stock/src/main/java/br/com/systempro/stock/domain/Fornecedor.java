package br.com.systempro.stock.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String razaoSocial;
	private String nomeContato;
	@Email
	private String email;
	@CNPJ
	private String cnpj;
	private String endereço;

	@JsonIgnore
	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "telefone_fornecedor")
	private Set<String> Telefones = new HashSet<>();

	public Fornecedor() {
	}

	public Fornecedor(Long id, String razaoSocial, String nomeContato, @Email String email, @CNPJ String cnpj,
			String endereço) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nomeContato = nomeContato;
		this.email = email;
		this.cnpj = cnpj;
		this.endereço = endereço;
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
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the nomeContato
	 */
	public String getNomeContato() {
		return nomeContato;
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
	 * @param nomeContato the nomeContato to set
	 */
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
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
	 * @return the produtos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @return the telefones
	 */
	public Set<String> getTelefones() {
		return Telefones;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(Telefones, cnpj, razaoSocial, endereço, id, nomeContato, produtos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(Telefones, other.Telefones) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(razaoSocial, other.razaoSocial) && Objects.equals(endereço, other.endereço)
				&& Objects.equals(id, other.id) && Objects.equals(nomeContato, other.nomeContato)
				&& Objects.equals(produtos, other.produtos);
	}

}
