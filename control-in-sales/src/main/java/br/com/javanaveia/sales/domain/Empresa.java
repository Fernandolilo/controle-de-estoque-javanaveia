package br.com.javanaveia.sales.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CNPJ;
@Entity
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CNPJ
	private String cnpj;
	private String rezaoSocial;
	private String nomeFantisia;
	private Long inscricaoEstadual;
	private Long inscrincaoMunicipal;
	private Long crc;
	private String endereco;
	
	@OneToMany(mappedBy = "empresa")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Empresa() {
	}

	public Empresa(Long id, @CNPJ String cnpj, String rezaoSocial, String nomeFantisia, Long inscricaoEstadual,
			Long inscrincaoMunicipal, Long crc, String endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.rezaoSocial = rezaoSocial;
		this.nomeFantisia = nomeFantisia;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscrincaoMunicipal = inscrincaoMunicipal;
		this.crc = crc;
		this.endereco = endereco;
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
	 * @return the rezaoSocial
	 */
	public String getRezaoSocial() {
		return rezaoSocial;
	}

	/**
	 * @param rezaoSocial the rezaoSocial to set
	 */
	public void setRezaoSocial(String rezaoSocial) {
		this.rezaoSocial = rezaoSocial;
	}

	/**
	 * @return the nomeFantisia
	 */
	public String getNomeFantisia() {
		return nomeFantisia;
	}

	/**
	 * @param nomeFantisia the nomeFantisia to set
	 */
	public void setNomeFantisia(String nomeFantisia) {
		this.nomeFantisia = nomeFantisia;
	}

	/**
	 * @return the inscricaoEstadual
	 */
	public Long getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	/**
	 * @param inscricaoEstadual the inscricaoEstadual to set
	 */
	public void setInscricaoEstadual(Long inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	/**
	 * @return the inscrincaoMunicipal
	 */
	public Long getInscrincaoMunicipal() {
		return inscrincaoMunicipal;
	}

	/**
	 * @param inscrincaoMunicipal the inscrincaoMunicipal to set
	 */
	public void setInscrincaoMunicipal(Long inscrincaoMunicipal) {
		this.inscrincaoMunicipal = inscrincaoMunicipal;
	}

	/**
	 * @return the crc
	 */
	public Long getCrc() {
		return crc;
	}

	/**
	 * @param crc the crc to set
	 */
	public void setCrc(Long crc) {
		this.crc = crc;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
}
