package se.lexicon.todoapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.todoapi.domain.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    Boolean existsByEmail(String email);

    // Update the expired field of a specific user by its email
    @Modifying
    @Query("update User u set u.expired = :status where u.email = :email")
    void updateExpiredByEmail(@Param("email") String email, @Param("status") boolean status);

    //update password
    @Modifying
    @Query("update User u set u.password = :password where u.email = :email")
    void updatePasswordByEmail(@Param("email") String email, @Param("password") String password);
}
