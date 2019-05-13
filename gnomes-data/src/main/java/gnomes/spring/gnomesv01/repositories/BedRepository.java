package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Bed;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BedRepository extends CrudRepository<Bed, Long> {
    Optional<Bed> findByName(String name);
}
