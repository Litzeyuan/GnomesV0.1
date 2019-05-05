package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Location;
import gnomes.spring.gnomesv01.repositories.AreaRepository;
import gnomes.spring.gnomesv01.repositories.LocationRepository;
import gnomes.spring.gnomesv01.services.interfaces.LocationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpaServices")
public class LocationJPAService implements LocationService {

    LocationRepository locationRepository;
    AreaRepository areaRepository;

    public LocationJPAService(LocationRepository locationRepository, AreaRepository areaRepository) {
        this.locationRepository = locationRepository;
        this.areaRepository = areaRepository;
    }

    @Override
    public Optional<Location> findByName(String name) {
        return locationRepository.findByName(name);
    }

    @Override
    public Set<Location> findAll() {
        Set<Location> locations = new HashSet<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return locationRepository.count();
    }
}
