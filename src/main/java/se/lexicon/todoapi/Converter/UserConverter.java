package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.UserDTOForm;
import se.lexicon.todoapi.domain.dto.UserDTOView;
import se.lexicon.todoapi.domain.entity.User;

@Component
public interface UserConverter {

    UserDTOView toUserDTO(User entity);

    User toEntity(UserDTOForm dto);

}
