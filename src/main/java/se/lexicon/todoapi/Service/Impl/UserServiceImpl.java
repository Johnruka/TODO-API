package se.lexicon.todoapi.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.todoapi.Repository.RoleRepository;
import se.lexicon.todoapi.Repository.UserRepository;
import se.lexicon.todoapi.Service.UserService;
import se.lexicon.todoapi.domain.dto.RoleDTOView;
import se.lexicon.todoapi.domain.dto.UserDTOForm;
import se.lexicon.todoapi.domain.dto.UserDTOView;
import se.lexicon.todoapi.domain.entity.Role;
import se.lexicon.todoapi.domain.entity.User;
import se.lexicon.todoapi.exception.DataDuplicateException;
import se.lexicon.todoapi.exception.dataNotFoundException;
import se.lexicon.todoapi.util.CustomPasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CustomPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDTOView register(UserDTOForm userDTOForm) {

        //1. Check parameter
        if (userDTOForm == null) throw new IllegalArgumentException("User form cannot be null");
        //2. Check if email exists in the DB
        boolean doesExistEmail = userRepository.existsByEmail(userDTOForm.getEmail());
        if (doesExistEmail) throw new DataDuplicateException("Email already exists");
        //3. Validate roles in repository and retrieve them
        Set<Role> roleList = userDTOForm.getRoles()
                .stream()
                .map(
                        roleDTOForm -> roleRepository.findById(roleDTOForm.getId())
                                .orElseThrow(() -> new dataNotFoundException("Role is not valid")))
                .collect(Collectors.toSet());
        //4. Convert UserDTOForm to User entity
        //todo: 5. Hash the password
        User user = User.builder()
                .email(userDTOForm.getEmail())
                .password(passwordEncoder.encode(userDTOForm.getPassword()))
                .roles(roleList)
                .build();
        //6. Save User to the DB
        User savedUser = userRepository.save(user);
        //7. Convert the repository result to UserDTOView
        //8. return the result
        Set<RoleDTOView> roleDTOViews = savedUser.getRoles()
                .stream()
                .map(
                        role -> RoleDTOView.builder()
                                .id(role.getId())
                                .name(role.getName())
                                .build())
                .collect(Collectors.toSet());

        return UserDTOView.builder()
                .email(savedUser.getEmail())
                .roles(roleDTOViews)
                .build();

    }

    @Override
    public UserDTOView getByEmail(String email) {
        User user = userRepository.findById(email).orElseThrow(() -> new dataNotFoundException("Email does not exist"));
        Set<RoleDTOView> roleDTOViews = user.getRoles()
                .stream()
                .map(
                        role -> RoleDTOView.builder()
                                .id(role.getId())
                                .name(role.getName())
                                .build())
                .collect(Collectors.toSet());

        return UserDTOView.builder()
                .email(user.getEmail())
                .roles(roleDTOViews)
                .build();

    }

    @Override
    @Transactional
    public void disableByEmail(String email) {
        isEmailTaken(email);
        userRepository.updateExpiredByEmail(email, true);
    }

    private void isEmailTaken(String email) {

    }

    @Override
    public void enableByEmail(String email) {
        if (!userRepository.existsByEmail(email)) throw new dataNotFoundException("Email does not exist");
    }


}

