package se.lexicon.todoapi.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.lexicon.todoapi.domain.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {




    //find all persons who have no task
    @Query("select p from Person p where SIZE(p.tasks) = 0 ")
    List<Person> findIdlePeople();

    //Find Persons who have no tasks
    @Query(value = "select * from person p where id not in(select t.person_id from person p join task t on p.id = t.person_id and t.person_id is not null)", nativeQuery = true)
    List<Person> findPersonsWithNoTasks();

    //Find Person by User email
    Optional<Person> findByUser_Email(String email);

    //Update Person name
    @Transactional
    @Modifying
    @Query("update Person p set p.name = :name where p.id = :id")
    void updatePersonNameById(Long id, String name);



}
