package ee.valiit.catmanager.persistence.cat;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Integer> {
    boolean existsByUserIdAndName(Integer userId, String name);

    List<Cat> findByUserId(Integer userId, Sort sort);

}