package br.com.javanaveia.client.domain.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Pedido implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime instante;

	
	public Pedido () {
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

}
