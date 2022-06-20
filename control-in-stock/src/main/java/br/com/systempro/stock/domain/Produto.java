package br.com.systempro.stock.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Produtos")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private Long id;
	@Column(name="nome", length = 250, nullable = false)
	private String nome;
	@Column(name="marca", length = 50, nullable = false)
	private String marca;
	@Column(name="descricao", length = 350, nullable = false)
	private String descricao;
	@Column(name="preco", length = 10, nullable = false)
	private Double preco;
	@Column(name="margem", length = 10, nullable = false)
	private Double margem;
	@Column(name="preco_venda", length = 10, nullable = false)
	private Double precoVenda;
	@Column(name="quantidade", length = 20, nullable = false)
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;

	public Produto() {
	}

	public Produto(Long id, String nome, String marca, String descricao, Double preco, Double precoVenda,
			Double margem, Integer quantidade,
			Categoria categoria, Fornecedor fornecedor) {
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.descricao = descricao;
		this.preco = preco;
		this.precoVenda = precoVenda;
		this.margem = margem;
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the fornecedore
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * @param fornecedore the fornecedore to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * @return the margem
	 */
	public Double getMargem() {
		return margem;
	}

	/**
	 * @param margem the margem to set
	 */
	public void setMargem(Double margem) {
		this.margem = margem;
	}

	/**
	 * @return the precoVenda
	 */
	public Double getPrecoVenda() {
		return precoVenda * margem;
	}

	/**
	 * @param precoVenda the precoVenda to set
	 */
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda * margem;
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
		return "Produto [id=" + id + ", nome=" + nome + ", marca=" + marca + ", descricao=" + descricao + ", preco="
				+ preco + ", quantidade=" + quantidade + ", categoria=" + categoria + ", fornecedor=" + fornecedor
				+ "]";
	}

}
