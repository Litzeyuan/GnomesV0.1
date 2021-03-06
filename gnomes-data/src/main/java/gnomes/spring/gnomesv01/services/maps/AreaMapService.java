package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Area;
import gnomes.spring.gnomesv01.services.interfaces.AreaService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("maps")
public class AreaMapService extends AbstractMapService<Area, Long> implements AreaService{

    @Override
    public List<Area> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Area> findById(Long id) {
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
    public void delete(Area area) {
        super.delete(area);
    }

    @Override
    public Area save(Area area) {
        return super.save(area);
    }

    @Override
    public Optional<Area> findByName(String name) {
        return this.findAll()
                .stream()
                .filter(area -> area.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
