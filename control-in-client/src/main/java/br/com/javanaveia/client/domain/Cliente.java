package br.com.javanaveia.client.domain;

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

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String password;
	private String cpfOuCnpj;

	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "telefone_cliete")
	private Set<String> Telefones = new HashSet<>();

	public Cliente() {
	}

	public Cliente(Long id, String nome, String email, String password, String cpfOuCnpj) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
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
		cpfOuCnpj = cpfOuCnpj;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the enderecos
	 */
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	/**
	 * @return the telefones
	 */
	public Set<String> getTelefones() {
		return Telefones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfOuCnpj, Telefones, email, enderecos, id, nome, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpfOuCnpj, other.cpfOuCnpj) && Objects.equals(Telefones, other.Telefones)
				&& Objects.equals(email, other.email) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password);
	}

}
