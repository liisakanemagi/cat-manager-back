package ee.valiit.catmanager.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUsersByUsername(String username);

    @Query("select (count(u) > 0) from User u where u.username = :username")
    boolean userExistsByUsername(@Param("username") String username);

    @Query("select (count(u) > 0) from User u where u.email = :email")
    boolean userExistsByEmail(@Param("email") String email);


}