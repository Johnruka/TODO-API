package se.lexicon.todoapi.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.todoapi.domain.dto.UserDTOForm;
import se.lexicon.todoapi.domain.dto.UserDTOView;
import se.lexicon.todoapi.domain.entity.User;
import se.lexicon.todoapi.util.CustomPasswordEncoder;

@Component
public class UserConverterImpl implements UserConverter {

    RoleConverter roleConverter;
    CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    public UserConverterImpl(RoleConverter roleConverter, CustomPasswordEncoder customPasswordEncoder) {
        this.roleConverter = roleConverter;
        this.customPasswordEncoder = customPasswordEncoder;
    }


    @Override
    public UserDTOView toUserDTO(User entity) {
        return UserDTOView.builder().email(entity.getEmail()).build();

    }

    @Override
    public User toEntity(UserDTOForm dto) {
        return User.builder().email(dto.getEmail()).build();
    }
}
