package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@Profile({"default", "maps"})
public class CropMapService extends AbstractMapService<Crop, Long> implements CropService {

    @Override
    public Set<Crop> findAll() {
        return super.findAll();
    }

    @Override
    public Crop findById(Long id) {
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
    public void delete(Crop crop) {
        super.delete(crop);
    }

    @Override
    public Crop save(Crop crop) {
        return super.save(crop);
    }

    @Override
    public Optional<Crop> findByName(String name) {
        return null;
    }

    @Override
    public Optional<Crop> findByVariety(String variety) {
        return null;
    }
}
