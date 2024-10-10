package se.lexicon.todoapi.Repository;

import org.springframework.data.jpa.repository.Query;
import se.lexicon.todoapi.domain.entity.Person;

import java.util.List;

public interface PersonRepository {

    //find all persons who have no task
    @Query("select p from Person p where SIZE(p.tasks) = 0 ")
    List<Person> findIdlePeople();
}
