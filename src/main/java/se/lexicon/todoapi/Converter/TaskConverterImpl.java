package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.TaskDTOForm;
import se.lexicon.todoapi.domain.dto.TaskDTOView;
import se.lexicon.todoapi.domain.entity.Task;

@Component
public class TaskConverterImpl implements TaskConverter{


    @Override
    public TaskDTOView toTaskDTO(TaskDTOView entity) {
        return TaskDTOView.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .deadline(entity.getDeadline())
                .done(entity.isDone())
                .build();
    }

    @Override
    public Task toEntity(TaskDTOForm dto) {
        return Task.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .deadline(dto.getDeadline())
                .done(dto.isDone())
                .build();
    }
}
