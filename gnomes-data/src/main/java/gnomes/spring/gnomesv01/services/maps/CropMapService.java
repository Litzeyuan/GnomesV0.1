package gnomes.spring.gnomesv01.services.maps;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CropService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Profile("maps")
public class CropMapService extends AbstractMapService<Crop, Long> implements CropService {

    @Override
    public List<Crop> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Crop> findById(Long id) {
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
        return this.findAll()
                .stream()
                .filter(crop -> crop.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public Optional<Crop> findByVariety(String variety) {
        return this.findAll()
                .stream()
                .filter(crop -> crop.getVariety().equalsIgnoreCase(variety))
                .findFirst();
    }

    @Override
    public List<Crop> findAllByNameLike(String name) {
        return null;
    }

    @Override
    public List<Crop> findAllByVarietyLike(String variety) {
        return null;
    }
}
