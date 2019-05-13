package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Area;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AreaRepository extends CrudRepository<Area, Long> {
    Optional<Area> findByName(String name);
}
