package br.com.systempro.stock.domain.dto;

import java.io.Serializable;

import br.com.systempro.stock.domain.Categoria;
import br.com.systempro.stock.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String marca;
	private Double preco;
	private Integer quantidade;
	private Categoria categoria;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		marca = obj.getMarca();
		preco = obj.getPreco();
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

	
}
