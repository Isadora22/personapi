package com.digitalinnovation.personapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.personapi.dtos.request.PersonDTO;
import com.digitalinnovation.personapi.dtos.response.MessageResponseDTO;
import com.digitalinnovation.personapi.entities.Person;
import com.digitalinnovation.personapi.mappers.PersonMapper;
import com.digitalinnovation.personapi.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
		
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO
				.builder()
				.message("Created peraon with Id " + savedPerson.getId())
				.build();
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				.map(personMapper :: toDTO)
				.collect(Collectors.toList());
	}
}
