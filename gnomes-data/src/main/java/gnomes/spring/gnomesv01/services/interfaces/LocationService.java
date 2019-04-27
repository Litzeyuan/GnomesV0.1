package gnomes.spring.gnomesv01.services.interfaces;

import gnomes.spring.gnomesv01.models.Location;

public interface LocationService extends CRUDService<Location, Long>{

    Location findByName(String name);

}
