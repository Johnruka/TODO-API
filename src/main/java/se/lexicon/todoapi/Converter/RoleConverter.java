package se.lexicon.todoapi.Converter;

import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.RoleDTOForm;
import se.lexicon.todoapi.domain.dto.RoleDTOView;
import se.lexicon.todoapi.domain.entity.Role;

@Component
public interface RoleConverter {

    RoleDTOView toRoleDTO(RoleDTOView entity);

    Role toEntity(RoleDTOForm dto);
}
