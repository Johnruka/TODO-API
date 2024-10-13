package se.lexicon.todoapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.lexicon.todoapi.Repository.RoleRepository;
import se.lexicon.todoapi.Repository.UserRepository;
import se.lexicon.todoapi.Service.Impl.UserServiceImpl;
import se.lexicon.todoapi.util.CustomPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private CustomPasswordEncoder passwordEncoder;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }


}
