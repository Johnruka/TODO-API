package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.PersonDTOForm;
import se.lexicon.todoapi.domain.dto.PersonDTOView;
import se.lexicon.todoapi.domain.entity.Person;

@Component
public interface PersonConverter {

    PersonDTOView toRoleDTO(PersonDTOView entity);

    Person toEntity(PersonDTOForm dto);


}
