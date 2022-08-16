package br.com.javanaveia.sales.domain.enums;

public enum StatusPedido {

	ANALISE(1, "ROLE_ANALISE"),
	SEPARACAO(2, "ROLE_SEPARACAO"),
	ENVIO_TRANSPORTADOR(3, "ROLE_ENVIO_TRANSPORTADOR"),
	ENTREGUE(4, "ROLE_ENTREGUE"),
	CANCELADO(5, "ROLE_CANCELADO"),;

	private Integer cod;
	private String descricao;

	private StatusPedido(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	/**
	 * @return the cod
	 */
	public Integer getCod() {
		return cod;
	}

	/**
	 * @param cod the cod to set
	 */
	public void setCod(Integer cod) {
		this.cod = cod;
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

	public static StatusPedido toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusPedido x : StatusPedido.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Id Invalido" + cod);

	}

}
