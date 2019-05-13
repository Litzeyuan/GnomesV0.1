package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Location;
import gnomes.spring.gnomesv01.services.interfaces.LocationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("maps")
public class LocationMapService extends AbstractMapService<Location, Long> implements LocationService {
    @Override
    public List<Location> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Long count() {
        return super.count();
    }

    @Override
    public void delete(Location location) {
        super.delete(location);
    }

    @Override
    public Location save(Location location) {
        return super.save(location);
    }

    @Override
    public Optional<Location> findByName(String name) {
        return this.findAll()
                .stream()
                .filter(location -> location.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
