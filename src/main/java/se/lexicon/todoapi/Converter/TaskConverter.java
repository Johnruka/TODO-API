package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.TaskDTOForm;
import se.lexicon.todoapi.domain.dto.TaskDTOView;
import se.lexicon.todoapi.domain.entity.Task;

@Component
public interface TaskConverter {

    TaskDTOView toTaskDTO(TaskDTOView entity);

    Task toEntity(TaskDTOForm dto);


}
