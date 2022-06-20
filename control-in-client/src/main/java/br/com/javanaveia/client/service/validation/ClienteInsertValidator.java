package br.com.javanaveia.client.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.javanaveia.client.controller.exceptions.FieldMessage;
import br.com.javanaveia.client.domain.DTO.ClientNewDTO;
import br.com.javanaveia.client.enums.TipoClient;
import br.com.javanaveia.client.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClientNewDTO> {

	@Override
	public void initialize(ClienteInsert ann) {

	}

	@Override
	public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipo().equals(TipoClient.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj ", "CPF Inválido!"));
		}
		if (objDto.getTipo().equals(TipoClient.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj ", "CNPJ Inválido!"));
		}
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getMessage())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
