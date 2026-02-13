package ee.valiit.catmanager.persistence.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CatRepository extends JpaRepository<Cat, Integer> {
    @Query("select (count(c) > 0) from Cat c where c.user.id = :userId and c.name = :name")
    boolean catExistsBy(@Param("userId") Integer userId, @Param("name") String name);
}