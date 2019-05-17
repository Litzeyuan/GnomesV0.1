package gnomes.spring.gnomesv01.services.jpaServices;

import gnomes.spring.gnomesv01.models.Area;
import gnomes.spring.gnomesv01.repositories.AreaRepository;
import gnomes.spring.gnomesv01.repositories.BedRepository;
import gnomes.spring.gnomesv01.services.interfaces.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Profile({"default","jpaServices"})
public class AreaJPAService implements AreaService {

    private AreaRepository areaRepository;
    private BedRepository bedRepository;

    public AreaJPAService(AreaRepository areaRepository, BedRepository bedRepository) {
        this.areaRepository = areaRepository;
        this.bedRepository = bedRepository;
    }

    @Override
    public Optional<Area> findByName(String name) {
        log.debug("AreaJPAService - findByName", name);

        return areaRepository.findByName(name);
    }

    @Override
    public List<Area> findAll() {
        log.debug("AreaJPAService - findAll");

        List<Area> areas = new ArrayList<>();
        areaRepository.findAll().forEach(areas::add);
        return areas;
    }

    @Override
    public Optional<Area> findById(Long id) {
        log.debug("AreaJPAService - findById", id);

        return areaRepository.findById(id);
    }

    @Override
    public Area save(Area area) {
        log.debug("AreaJPAService - save", area);

        return areaRepository.save(area);
    }

    @Override
    public void delete(Area area) {
        log.debug("AreaJPAService - delete", area);

        areaRepository.delete(area);

    }

    @Override
    public void deleteById(Long id) {
        log.debug("AreaJPAService - deleteById", id);

        areaRepository.deleteById(id);

    }

    @Override
    public Long count() {
        log.debug("AreaJPAService - count");

        return areaRepository.count();
    }
}
