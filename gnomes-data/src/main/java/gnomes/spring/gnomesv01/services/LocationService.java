package gnomes.spring.gnomesv01.services;

import gnomes.spring.gnomesv01.models.Location;

import java.util.Set;

public interface LocationService {

    Location findById(long id);

    Location findByName(String name);

    Set<Location> findAll();
}
