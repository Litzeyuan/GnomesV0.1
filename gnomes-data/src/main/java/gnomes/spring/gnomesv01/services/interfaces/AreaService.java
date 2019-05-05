package gnomes.spring.gnomesv01.services.interfaces;

import gnomes.spring.gnomesv01.models.Area;

import java.util.Optional;

public interface AreaService extends CRUDService<Area, Long> {
    Optional<Area> findByName(String name);
}
