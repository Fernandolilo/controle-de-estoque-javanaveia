package br.com.systempro.stock.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;

public class FornecedorNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String razaoSocial;
	private String nomeContato;
	@Email
	private String email;
	@CNPJ
	private String cnpj;
	private String endereço;
	private String fone1;
	private String fone2;
	private String fone3;
	
	

}
