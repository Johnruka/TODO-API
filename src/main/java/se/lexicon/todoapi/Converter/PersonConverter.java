package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.PersonDTOForm;
import se.lexicon.todoapi.domain.dto.PersonDTOView;
import se.lexicon.todoapi.domain.entity.Person;

@Component
public interface PersonConverter {

    Person toPersonEntitySave(PersonDTOForm dtoFormSave);

    Person toPersonEntityForm(PersonDTOForm dtoForm);

    PersonDTOView toPersonDTOView(Person entity);

    PersonDTOView toPersonDTOView(PersonDTOForm dto);

    PersonDTOForm toPersonDTOForm(PersonDTOView entity);

    PersonDTOForm toPersonDTOFormEntity(Person entity);
}
