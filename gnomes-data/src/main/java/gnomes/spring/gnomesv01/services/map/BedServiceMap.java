package gnomes.spring.gnomesv01.services.map;

import gnomes.spring.gnomesv01.models.Bed;
import gnomes.spring.gnomesv01.services.interfaces.CRUDService;

import java.util.Set;

public class BedServiceMap extends AbstractMapService<Bed, Long> implements CRUDService<Bed, Long> {
    @Override
    public Set<Bed> findAll() {
        return findAll();
    }

    @Override
    public Bed findById(Long id) {
        return findById(id);
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
    public void delete(Bed bed) {
        super.delete(bed);
    }

    @Override
    public void save(Bed bed) {
        super.save(bed.getId(), bed);
    }
}