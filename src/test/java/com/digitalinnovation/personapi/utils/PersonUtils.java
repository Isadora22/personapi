package com.digitalinnovation.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.digitalinnovation.personapi.dtos.request.PersonDTO;
import com.digitalinnovation.personapi.entities.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME = "Maria";
	private static final String LAST_NAME = "da Silva";
	private static final String CPF_NUMBER = "222.306.460-44";
	private static final String EMAIL = "maria_silva@gmail.com";
	private static final long PERSON_ID = 1L;
	public static final LocalDate BIRTH_DATE = LocalDate.of(2015, 10, 1);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)				
				.birthDate("10-01-2015")
				.email(EMAIL)
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)				
				.birthDate(BIRTH_DATE)
				.email(EMAIL)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}
	

}
