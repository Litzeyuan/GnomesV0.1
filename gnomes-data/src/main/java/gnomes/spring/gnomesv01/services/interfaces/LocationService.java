package gnomes.spring.gnomesv01.services.interfaces;

import gnomes.spring.gnomesv01.models.Location;

import java.util.Optional;

public interface LocationService extends CRUDService<Location, Long>{

    Optional<Location> findByName(String name);

}
