package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.PersonDTOForm;
import se.lexicon.todoapi.domain.dto.PersonDTOView;
import se.lexicon.todoapi.domain.entity.Person;

@Component
public class PersonConverterImpl implements PersonConverter {


    @Override
    public PersonDTOView toPersonDTO(PersonDTOView entity) {
        return PersonDTOView.builder().id(entity.getId()).name(entity.getName()).build();
        // return new PersonDTOView(entity.getId(), entity.getName());
    }

    @Override
    public Person toEntity(PersonDTOForm dto) {
        return Person.builder().id(dto.getId()).name(dto.getName()).build();
        // return new Person(dto.getId(), dto.getName());
    }
}



