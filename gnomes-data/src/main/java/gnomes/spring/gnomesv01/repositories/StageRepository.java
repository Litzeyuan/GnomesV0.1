package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Stage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StageRepository extends CrudRepository<Stage,Long> {
    Optional<Stage> findByName(String name);
}
