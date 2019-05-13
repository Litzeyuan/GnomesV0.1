package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Optional<Location> findByName(String name);
}
