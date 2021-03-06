package br.com.javanaveia.client.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.javanaveia.client.enums.Perfil;
import br.com.javanaveia.client.enums.TipoClient;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	@JsonIgnore
	private String password;
	private String cpfOuCnpj;
	private Integer tipo;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "telefone_cliete")
	private Set<String> Telefones = new HashSet<>();

	public Cliente() {
		addPerfil(Perfil.USUARIO);
	}

	public Cliente(Long id, String nome, String email, String password, String cpfOuCnpj, TipoClient tipoCliente) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipoCliente == null) ? null : tipoCliente.getCod();
		addPerfil(Perfil.USUARIO);
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
		this.cpfOuCnpj = cpfOuCnpj;
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

	public TipoClient getTipo() {
		return TipoClient.toEnum(tipo);
	}

	public void setTipo(TipoClient tipo) {
		this.tipo = tipo.getCod();
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	@Override
	public int hashCode() {
		return Objects.hash(Telefones, cpfOuCnpj, email, enderecos, id, nome, password);
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
		return Objects.equals(Telefones, other.Telefones) && Objects.equals(cpfOuCnpj, other.cpfOuCnpj)
				&& Objects.equals(email, other.email) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password);
	}

}
