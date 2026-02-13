package ee.valiit.catmanager.persistence.catstatus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatStatusRepository extends JpaRepository<CatStatus, Integer> {
}