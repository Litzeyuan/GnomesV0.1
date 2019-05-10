package gnomes.spring.gnomesv01.repositories;

import gnomes.spring.gnomesv01.models.Area;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<Area, Long> {
    Area findByName(String name);
}
