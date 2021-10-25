package com.digitalinnovation.personapi.dtos.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.digitalinnovation.personapi.entities.Phone;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	
	private Long id;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	private String birthDate;
	
	@NotEmpty
	@Email
	private String email;
	
	@Valid
	@NotEmpty
	private List<PhoneDTO> phones;

}
