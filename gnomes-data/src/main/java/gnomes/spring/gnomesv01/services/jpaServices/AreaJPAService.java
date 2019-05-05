package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Area;
import gnomes.spring.gnomesv01.repositories.AreaRepository;
import gnomes.spring.gnomesv01.repositories.BedRepository;
import gnomes.spring.gnomesv01.services.interfaces.AreaService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("jpaServices")
public class AreaJPAService implements AreaService {
    AreaRepository areaRepository;
    BedRepository bedRepository;

    public AreaJPAService(AreaRepository areaRepository, BedRepository bedRepository) {
        this.areaRepository = areaRepository;
        this.bedRepository = bedRepository;
    }

    @Override
    public Optional<Area> findByName(String name) {
        return areaRepository.findByName(name);
    }

    @Override
    public Set<Area> findAll() {
        Set<Area> areas = new HashSet<>();
        areaRepository.findAll().forEach(areas::add);
        return areas;
    }

    @Override
    public Area findById(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public Area save(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public void delete(Area area) {
        areaRepository.delete(area);

    }

    @Override
    public void deleteById(Long id) {
        areaRepository.deleteById(id);

    }

    @Override
    public Long count() {
        return areaRepository.count();
    }
}
