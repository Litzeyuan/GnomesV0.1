package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Stage;
import org.springframework.data.repository.CrudRepository;

public interface StageRepository extends CrudRepository<Stage,Long> {
    Stage findByName(String name);
}
