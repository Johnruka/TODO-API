package se.lexicon.todoapi.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.todoapi.Repository.RoleRepository;
import se.lexicon.todoapi.domain.entity.Role;

@Component
public class RoleDataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleDataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
        public void run (String...args) throws Exception {

        System.out.println("#####################################");
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("GUEST"));
        }
    }
