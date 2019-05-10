package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByName(String name);
}
