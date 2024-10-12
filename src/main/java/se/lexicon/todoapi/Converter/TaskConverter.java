package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.TaskDTOForm;
import se.lexicon.todoapi.domain.dto.TaskDTOView;
import se.lexicon.todoapi.domain.entity.Task;

@Component
public interface TaskConverter {

    Task toTaskSave(TaskDTOForm dto);

    Task toTaskForm(TaskDTOForm dto);

    TaskDTOView toTaskDTOView(Task entity);

    TaskDTOView toTaskDTOViewWithoutPerson(Task entity);

    TaskDTOView toTaskDTOViewForm(TaskDTOForm dto);

    TaskDTOForm toTskDTOForm(TaskDTOForm dto);

    TaskDTOForm toTaskDTOForm(Task entity);
}
