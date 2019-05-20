package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Location;
import gnomes.spring.gnomesv01.repositories.AreaRepository;
import gnomes.spring.gnomesv01.repositories.LocationRepository;
import gnomes.spring.gnomesv01.services.interfaces.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Profile({"default","jpaServices"})
public class LocationJPAService implements LocationService {

    private LocationRepository locationRepository;
    private AreaRepository areaRepository;

    public LocationJPAService(LocationRepository locationRepository, AreaRepository areaRepository) {
        this.locationRepository = locationRepository;
        this.areaRepository = areaRepository;
    }

    @Override
    public Optional<Location> findByName(String name) {
        return locationRepository.findByName(name);
    }

    @Override
    public List<Location> findAll() {
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    @Override
    public Optional<Location> findById(Long id) {
        Optional<Location> location = locationRepository.findById(id);

        if (!location.isPresent())
            throw new RuntimeException("Location Not Found");

        return  location;
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
