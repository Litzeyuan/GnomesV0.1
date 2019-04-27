package gnomes.spring.gnomesv01.services.map;

import gnomes.spring.gnomesv01.models.Crop;
import gnomes.spring.gnomesv01.services.interfaces.CRUDService;

import java.util.Set;

public class CropServiceMap extends AbstractMapService<Crop, Long> implements CRUDService<Crop,Long> {

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
    public int count() {
        return super.count();
    }

    @Override
    public void delete(Crop crop) {
        super.delete(crop);
    }

    @Override
    public void save(Crop crop) {
        super.save(crop.getId(), crop);
    }
}
