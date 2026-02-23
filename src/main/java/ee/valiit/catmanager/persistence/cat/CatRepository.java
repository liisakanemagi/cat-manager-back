package ee.valiit.catmanager.persistence.cat;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CatRepository extends JpaRepository<Cat, Integer> {
    boolean ExistsByUserIdAndName(Integer userId, String name);

}