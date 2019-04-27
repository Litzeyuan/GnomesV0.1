package gnomes.spring.gnomesv01.services;

import gnomes.spring.gnomesv01.models.Location;
import gnomes.spring.gnomesv01.services.interfaces.LocationService;

import java.util.Set;

public class LocationServiceImpl implements LocationService {
    @Override
    public Location findByName(String name) {
        return null;
    }

    @Override
    public Set<Location> findAll() {
        return null;
    }

    @Override
    public Location findById(Long id) {
        return null;
    }

    @Override
    public void save(Location object) {

    }

    @Override
    public void delete(Location object) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public int count() {
        return 0;
    }
}
