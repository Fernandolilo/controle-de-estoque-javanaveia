package br.com.javanaveia.sales.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.javanaveia.sales.domain.ItemPedido;
import br.com.javanaveia.sales.domain.Pedido;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:ss:mm")
	private LocalDateTime instante;
	private Long idProduto;
	private List<ItemPedido> itens = new ArrayList<>();

	public PedidoDTO() {

	}
	public PedidoDTO(Pedido obj) {
		id = obj.getId();
		instante = obj.getInstante();
		itens = obj.getItens();
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
	 * @return the instante
	 */
	public LocalDateTime getInstante() {
		return instante;
	}
	/**
	 * @param instante the instante to set
	 */
	public void setInstante(LocalDateTime instante) {
		this.instante = instante;
	}
	/**
	 * @return the idProduto
	 */
	public Long getIdProduto() {
		return idProduto;
	}
	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the itens
	 */
	public List<ItemPedido> getItens() {
		return itens;
	}
	
}
