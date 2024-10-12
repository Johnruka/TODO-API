package se.lexicon.todoapi.Service.Impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.todoapi.Repository.PersonRepository;
import se.lexicon.todoapi.Service.PersonService;
import se.lexicon.todoapi.domain.dto.PersonDTOForm;
import se.lexicon.todoapi.domain.dto.PersonDTOView;
import se.lexicon.todoapi.domain.entity.Person;
import se.lexicon.todoapi.exception.dataNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    @Transactional
    public PersonDTOView create(PersonDTOForm personDTOForm) {
        if (personDTOForm == null) throw new IllegalArgumentException("PersonDto was null.");

        Person person = new Person(personDTOForm.getName());
        Person savedPerson = personRepository.save(person);
        return PersonDTOView.builder().id(savedPerson.getId()).name(savedPerson.getName()).build();
    }

    @Override
    public PersonDTOView findById(Long id) {
        Person person = (Person) personRepository.findById(id).orElseThrow(() -> new dataNotFoundException("Person id is not valid."));
        return PersonDTOView.builder().id(person.getId()).name(person.getName()).build();
    }

    @Override
    public List<PersonDTOView> findAll() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(person -> PersonDTOView.builder().id(person.getId()).name(person.getName()).build())
                .collect(Collectors.toList());


    }

    @Override
    public PersonDTOView update(PersonDTOForm personDTOForm) {
        Person person = (Person) personRepository.findById(personDTOForm.getId()).orElseThrow(() -> new dataNotFoundException("Person Id is not valid."));
        person.setName(personDTOForm.getName());
        return PersonDTOView.builder().id(person.getId()).name(person.getName()).build();
    }

    @Override
    public void delete(Long id) {
        Person person = (Person) personRepository.findById(id).orElseThrow(() -> new dataNotFoundException("Person id is not valid."));
        personRepository.delete(person);
    }

    }


