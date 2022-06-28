package br.com.javanaveia.client.enums;

public enum Perfil {

	ADMINISTRADOR(1, "ROLE_ADMIN"),
	USUARIO(2, "ROLE_USER");

	private Integer cod;
	private String descricao;

	private Perfil(int cod, String descricao) {
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

	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}

		}
		throw new IllegalArgumentException("Id Invalido" + cod);

	}

}
