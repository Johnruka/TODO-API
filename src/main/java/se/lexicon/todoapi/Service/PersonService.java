package se.lexicon.todoapi.Service;

import se.lexicon.todoapi.domain.dto.PersonDTOForm;
import se.lexicon.todoapi.domain.dto.PersonDTOView;

import java.util.List;

public interface PersonService {

    PersonDTOView create(PersonDTOForm personDTOForm);

    PersonDTOView findById(Long id);

    List<PersonDTOView> findAll();

    PersonDTOView update(PersonDTOForm personDTOForm);

    void delete(Long id);
}
