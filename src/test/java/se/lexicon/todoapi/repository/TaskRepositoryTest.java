package se.lexicon.todoapi.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.todoapi.Repository.PersonRepository;
import se.lexicon.todoapi.Repository.TaskRepository;
import se.lexicon.todoapi.domain.entity.Person;
import se.lexicon.todoapi.domain.entity.Task;

import java.time.LocalDate;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PersonRepository personRepository;

    private Person person;


    @BeforeEach
    void setUp() {
        LocalDate today = LocalDate.now();
        person = personRepository.save(new Person("John"));

        taskRepository.save(new Task("Title 1", "task todo 1", today, person));
        taskRepository.save(new Task("Title 2", "task todo 2", today.plusDays(1), true, person));
        taskRepository.save(new Task("Title 3", "task todo 3", today.plusDays(2), person));
        taskRepository.save(new Task("Title 4", "task todo 4", today.minusDays(34)));

    }
}















