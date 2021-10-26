package com.digitalinnovation.personapi.services;

import static com.digitalinnovation.personapi.utils.PersonUtils.createFakeDTO;
import static com.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digitalinnovation.personapi.dtos.request.PersonDTO;
import com.digitalinnovation.personapi.dtos.response.MessageResponseDTO;
import com.digitalinnovation.personapi.entities.Person;
import com.digitalinnovation.personapi.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOTheReturnsSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();
		
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());		
		MessageResponseDTO successMessage = personService.createPerson(personDTO);		
		
		assertEquals(expectedSuccessMessage, successMessage);
	}
	
	private MessageResponseDTO createExpectedMessageResponse(Long id) {
		return MessageResponseDTO
				.builder()
				.message("Created person with Id " + id)
				.build();
	}
	
}
