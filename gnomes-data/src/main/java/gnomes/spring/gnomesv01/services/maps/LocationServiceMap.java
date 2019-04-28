package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Location;
import gnomes.spring.gnomesv01.services.interfaces.LocationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LocationServiceMap extends AbstractMapService<Location, Long> implements LocationService {
    @Override
    public Set<Location> findAll() {
        return super.findAll();
    }

    @Override
    public Location findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public void delete(Location location) {
        super.delete(location);
    }

    @Override
    public void save(Location location) {
        super.save(location);
    }

    @Override
    public Location findByName(String name) {
        return null;
    }
}
