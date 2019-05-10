package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Bed;
import org.springframework.data.repository.CrudRepository;

public interface BedRepository extends CrudRepository<Bed, Long> {
    Bed findByName(String name);
}
