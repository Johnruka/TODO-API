package se.lexicon.todoapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.todoapi.domain.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
