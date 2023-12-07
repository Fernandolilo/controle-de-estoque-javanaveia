package br.com.systempro.stock.domain.dto;

import java.io.Serializable;

import br.com.systempro.stock.domain.Categoria;
import br.com.systempro.stock.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String marca;
	private String descricao;
	private Double preco;
	private Double margem;
	private Double precoVenda;
	private Integer quantidade;
	private Categoria categoria;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Long id) {
		this.id = id;
	}

	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		marca = obj.getMarca();
		descricao = obj.getDescricao();
		preco = obj.getPreco();
		precoVenda = obj.getPrecoVenda();
		margem = obj.getMargem();
		quantidade = obj.getQuantidade();
		categoria = obj.getCategoria();

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

	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		return precoVenda;
	}

	/**
	 * @param precoVenda the precoVenda to set
	 */
	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

}
