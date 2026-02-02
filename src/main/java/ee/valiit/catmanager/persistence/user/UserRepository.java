package ee.valiit.catmanager.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUsersByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);


}