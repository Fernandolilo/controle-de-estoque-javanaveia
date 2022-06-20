package br.com.javanaveia.sales.domain;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String marca;
	private String descricao;
	private Double precoVenda;
	private Integer quantidade;

	public Produto() {
	}

	public Produto(Long id, String nome, String marca, String descricao, Double precoVenda, Integer quantidade) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.descricao = descricao;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoVenda() {
		return precoVenda ;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", precoVenda=" + precoVenda + ", quantidade=" + quantidade + "]";
	}

}
